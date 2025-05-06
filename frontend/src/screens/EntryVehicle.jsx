import React, { useState } from 'react';
import Input from "../components/Input"
import Button from "../components/Button"
import ButtonTransparent from "../components/ButtonTransparent"
import Alert from '../components/Alert';
import axios from 'axios';
import moment from "moment";
import 'moment/locale/pt-br'
moment.locale('pt-br')

export default function EntryVehicle() {
    const [alertProperties, setAlertProperties] = useState({ visible: false, type: '', title: '', text: '' });
    const [inputValues, setInputValues] = useState({
        placa: null,
        modelo: null,
        cor: null,
        dataHoraEntrada: null,
        cliente: null,
        bloco: null,
        idVeiculo: null,
        idCliente: null
    });

    function hiddenAlert() {
        setTimeout(() => {
            setAlertProperties({ visible: false, type: '', title: '', text: '' });
        }, 8000);
    }

    function registerEntry() {
        if (inputValues.placa == null) {
            setAlertProperties({ visible: true, type: 'error', title: 'Erro', text: 'A placa deve ser informada para registrar a entrada do veículo' });
            hiddenAlert();
            return
        } else if (inputValues.dataHoraEntrada == null) {
            setAlertProperties({ visible: true, type: 'error', title: 'Erro', text: 'A Data/Hora Entrada deve ser informada para registrar a entrada do veículo' });
            hiddenAlert();
            return
        }
        axios.post(import.meta.env.VITE_DB_URL + 'reserva', {
            ID_BLOCO: inputValues.bloco,
            DT_INICIO: moment(inputValues.dataHoraEntrada).format('YYYY-MM-DD HH:MM'),
            DT_FIM: null,
            STATUS: 'ATV',
            ID_VEICULO: inputValues.idVeiculo,
            DS_PLACA: inputValues.placa,
            DS_MODELO: inputValues.modelo,
            DS_COR: inputValues.cor,
            ID_CLIENTE: inputValues.idCliente
        })
            .then(function (response) {
                setAlertProperties({ visible: true, type: 'sucess', title: 'Sucesso', text: `O veículo de placa ${inputValues.placa} foi cadastrado a entrada com sucesso!` });
                setInputValues({
                    placa: null,
                    modelo: null,
                    cor: null,
                    dataHoraEntrada: null,
                    cliente: null,
                    bloco: null,
                    idVeiculo: null,
                    idCliente: null
                })

            })
            .catch(function (error) {
                console.log(error);
                setAlertProperties({ visible: true, type: 'error', title: 'Erro', text: 'Erro ao cadastrar entrada do veículo' });
            });
        hiddenAlert();
    }

    function searchVehicleByPlate(placa) {
        axios.get(import.meta.env.VITE_DB_URL + 'placaRetornaVeiculoClienteReserva/' + placa)
            .then(response => {
                const data = response.data;
                if (data.length > 0) {
                    setInputValues({ ...inputValues, placa: placa, modelo: data[0].DS_MODELO, cor: data[0].DS_COR, cliente: data[0].DS_NOME, idVeiculo: data[0].ID_VEICULO, idCliente: data[0].ID_CLIENTE })
                } else {
                    setInputValues({ ...inputValues, placa: placa, modelo: null, cor: null, cliente: null, idVeiculo: null, idCliente: null })
                }
            })
            .catch(error => {
                console.error(error);
            });
    }
    function searchClient(codigo) {
        axios.get(import.meta.env.VITE_DB_URL + 'cliente/' + codigo)
            .then(response => {
                const data = response.data;
                console.log(data)
                if (data.length == 1) {
                    setInputValues({ ...inputValues, cliente: data[0].DS_NOME, idCliente: data[0].ID_CLIENTE })
                } else {
                    setInputValues({ ...inputValues, idCliente: null, cliente: null })
                }
            })
            .catch(error => {
                console.error(error);
            });
    }

    return (
        <div className="duration-300">
            {alertProperties.visible && <Alert {...alertProperties} />}
            <div className="pb-8">
                <h1 className="text-2xl font-semibold">Registrar Entrada de Veículo</h1>
            </div>
            <form>
                <div className="space-y-12">
                    <div className="border-b border-gray-900/10 pb-12">
                        <div className=" grid grid-cols-1 gap-x-6 gap-y-8">
                            <Input type="text" name="placa" id="placa" autoComplete="off" label="Placa" placeholder="" obrigatory={'YES'} onChange={(value) => searchVehicleByPlate(value.target.value)} value={inputValues.placa || ''} />
                            <Input type="text" name="modelo" id="modelo" autoComplete="off" label="Modelo" placeholder="" obrigatory={'YES'} onChange={(value) => setInputValues({ ...inputValues, modelo: value.target.value })} value={inputValues.modelo || ''} />
                            <Input type="text" name="cor" id="cor" autoComplete="off" label="Cor" placeholder="" obrigatory={'YES'} onChange={(value) => setInputValues({ ...inputValues, cor: value.target.value })} value={inputValues.cor || ''} />
                            <Input type="datetime-local" name="dataHoraEntrada" id="dataHoraEntrada" autoComplete="off" label="Data/Hora Entrada" placeholder="" obrigatory={'YES'} onChange={(value) => setInputValues({ ...inputValues, dataHoraEntrada: value.target.value })} value={inputValues.dataHoraEntrada || ''} />
                            <Input type="text" name="id-cliente" id="id-cliente" autoComplete="off" label="Código Cliente" placeholder="" onChange={(value) => searchClient(value.target.value)} value={inputValues.idCliente || ''} />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Nome Cliente" disabled={true} onChange={(value) => setInputValues({ ...inputValues, cliente: value.target.value })} value={inputValues.cliente || ''} />
                            <Input type="number" name="bloco" id="bloco" autoComplete="off" label="Bloco" placeholder="" onChange={(value) => setInputValues({ ...inputValues, bloco: value.target.value })} value={inputValues.bloco || ''} />

                        </div>
                    </div>

                </div>

                <div className="mt-6 flex items-center justify-end gap-x-6">
                    <ButtonTransparent type="button">Cancelar</ButtonTransparent>
                    <Button type={'button'} onClick={() => registerEntry()} >Salvar</Button>
                </div>
            </form>
        </div>
    )
}

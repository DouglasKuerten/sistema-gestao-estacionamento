import React, { useState } from 'react';
import Input from "../components/Input"
import Button from "../components/Button"
import ButtonTransparent from "../components/ButtonTransparent"
import { Link } from "react-router-dom"
import Alert from '../components/Alert';
import PaymentVehicle from '../screens/PaymentVehicle';
import axios from 'axios';
import moment from "moment";
import 'moment/locale/pt-br'
moment.locale('pt-br')

export default function ExitVehicle() {
    const [alertProperties, setAlertProperties] = useState({ visible: false, type: '', title: '', text: '' });
    const [inputValues, setInputValues] = useState({
        placa: null,
        modelo: null,
        cor: null,
        dataHoraEntrada: null,
        dataHoraSaida: null,
        cliente: null,
        bloco: null,
        idVeiculo: null,
        idCliente: null,
        idReserva: null
    });
    const [valuePayment, setValuePayment] = useState(0);
    function hiddenAlert() {
        setTimeout(() => {
            setAlertProperties({ visible: false, type: '', title: '', text: '' });
        }, 8000);
    }

    function exitVehicle(idReserva) {
        if (inputValues.placa == null) {
            setAlertProperties({ visible: true, type: 'error', title: 'Erro', text: 'A placa deve ser informada para registrar a saída do veículo' });
            hiddenAlert();
            return
        } else if (inputValues.dataHoraEntrada == null) {
            setAlertProperties({ visible: true, type: 'error', title: 'Erro', text: 'A Data/Hora Saída deve ser informada para registrar a saída do veículo' });
            hiddenAlert();
            return
        }
        /*         DT_INICIO: moment(inputValues.dataHoraEntrada).format('YYYY-MM-DD HH:MM'),
                DT_FIM: moment(inputValues.dataHoraSaida).format('YYYY-MM-DD HH:MM'), */
        axios.put(import.meta.env.VITE_DB_URL + 'reserva/' + idReserva, {
            DT_INICIO: moment(inputValues.dataHoraEntrada).format('YYYY-MM-DD HH:MM:SS'),
            DT_FIM: moment(inputValues.dataHoraSaida).format('YYYY-MM-DD HH:MM:SS'),
            STATUS: 'NTA',
            ID_VEICULO: inputValues.idVeiculo,
            ID_BLOCO: inputValues.bloco,
            ID_RESERVA: idReserva
        }).then(function (response) {
            setAlertProperties({ visible: true, type: 'sucess', title: 'Sucesso', text: `O veículo de placa ${inputValues.placa} foi finalizado com sucesso!` });
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
        }).catch(function (error) {
            console.log(error);
            setAlertProperties({ visible: true, type: 'error', title: 'Erro', text: 'Erro ao registrar a saída do veículo' });
        });
        hiddenAlert();
    }

    function searchReserveByPlate(placa) {
        axios.get(import.meta.env.VITE_DB_URL + 'placaRetornaVeiculoClienteReserva/' + placa)
            .then(response => {
                const data = response.data;
                if (data.length > 0) {
                    setInputValues({ ...inputValues, placa: placa, modelo: data[0].DS_MODELO, cor: data[0].DS_COR, cliente: data[0].DS_NOME, idVeiculo: data[0].ID_VEICULO, idCliente: data[0].ID_CLIENTE, idReserva: data[0].ID_RESERVA, dataHoraEntrada: data[0].DT_INICIO, dataHoraSaida: data[0].DT_FIM, bloco: data[0].ID_BLOCO })
                } else {
                    setInputValues({ ...inputValues, placa: placa, modelo: null, cor: null, cliente: null, idVeiculo: null, idCliente: null, idReserva: null })
                }
            })
            .catch(error => {
                console.error(error);
            });
    }

    function searchValuePayment(idReserva, bloco) {
        axios.get(import.meta.env.VITE_DB_URL + 'valorTarifaPassandoReservaBloco/' + idReserva + "-" + bloco)
            .then(response => {
                const data = response.data;
                if (data.length > 0) {
                    console.log(data)
                    setValuePayment(data[0].VALOR != null ? data[0].VALOR : 0)
                } else {
                    setValuePayment(0)

                }
            })
            .catch(error => {
                console.error(error);
            });

    }

    function calculaTempo(dataHoraEntrada, dataHoraSaida) {
        let inicio = new Date(dataHoraEntrada);
        let fim = new Date(dataHoraSaida);
        let diferenca = new Date(fim - inicio);

        let resultado = diferenca.getUTCHours() + "h ";
        resultado += diferenca.getUTCMinutes() + "m ";
        resultado += diferenca.getUTCSeconds() + "s ";
        return resultado;
    }

    function onChangeEndDate(dataHoraSaidaValue, idReserva, bloco) {
        setInputValues({ ...inputValues, dataHoraSaida: dataHoraSaidaValue });
        searchValuePayment(idReserva, bloco);
    }

    return (
        <div className="duration-300">

            {alertProperties.visible && <Alert {...alertProperties} />}
            <div className="pb-8">
                <h1 className="text-2xl font-semibold">Registrar Saída de Veículo</h1>
            </div>

            <form>
                <div className="space-y-12">
                    <div className="pb-12">
                        <div className=" grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Placa" placeholder="" obrigatory={'YES'} onInput={(value) => searchReserveByPlate(value.target.value)} value={inputValues.placa || ''} />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Modelo" placeholder="" disabled value={inputValues.modelo || ''} />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Cor" placeholder="" disabled value={inputValues.cor || ''} />
                            <Input type="datetime-local" name="cliente" id="cliente" autoComplete="off" label="Data/Hora Saída" placeholder="" obrigatory={'YES'} onChange={(value) => onChangeEndDate(value.target.value, inputValues.idReserva, inputValues.bloco)} value={inputValues.dataHoraSaida || ''} />
                            <Input type="text" name="id-cliente" id="id-cliente" autoComplete="off" label="Código Cliente" disabled={true} placeholder="" value={inputValues.idCliente || ''} />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Nome Cliente" disabled={true} value={inputValues.cliente || ''} />
                        </div>

                        <div className="border-b border-t border-gray-900/10 pb-5 my-5">
                            <div className="py-3">
                                <h2 className="text-base font-semibold">Resumo do Período Estacionado</h2>
                            </div>
                            <div className="flex pb-3 gap-10">
                                <div>
                                    <h4 className="text-sm font-semibold leading-7 text-gray-900">Entrada</h4>
                                    <p className="mt-1 text-sm leading-6 text-gray-600">
                                        {moment(inputValues.dataHoraEntrada).format('DD/MM/YYYY HH:MM')}
                                    </p>
                                </div>
                                <div>
                                    <h4 className="text-sm font-semibold leading-7 text-gray-900">Saída</h4>
                                    <p className="mt-1 text-sm leading-6 text-gray-600">
                                        {moment(inputValues.dataHoraSaida).format('DD/MM/YYYY HH:MM')}
                                    </p>
                                </div>
                            </div>
                            <h4 className="text-sm font-semibold leading-7 text-gray-900">Horas Estacionado</h4>
                            <p className="mt-1 text-sm leading-6 text-gray-600 ">
                                {calculaTempo(inputValues.dataHoraEntrada, inputValues.dataHoraSaida)}
                            </p>
                        </div>
                        <div className="flex flex-row justify-between border-b border-gray-900/10 pb-5">
                            <div className='flex flex-col'>
                                <h2 className="text-base font-semibold leading-7 text-gray-900">Valor</h2>
                                <p className="mt-1 text-sm leading-6 text-gray-600 ">
                                    {valuePayment.toLocaleString("pt-BR", { minimumFractionDigits: 2, maximumFractionDigits: 2 })}
                                </p>
                            </div>
                            <div className="mt-6 flex items-center justify-end gap-x-6">
                                <ButtonTransparent type="button">Cancelar</ButtonTransparent>
                                <Button type={'button'} onClick={() => exitVehicle(inputValues.idReserva)}>
                                    Encerrar
                                </Button>
                            </div>
                        </div>
                    </div>
                </div>


            </form>

        </div>
    )
}

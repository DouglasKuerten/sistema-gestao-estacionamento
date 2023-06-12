import React, { useState } from 'react';
import Input from "../components/Input"
import Button from "../components/Button"
import ButtonTransparent from "../components/ButtonTransparent"
import Alert from '../components/Alert';




export default function EntryVehicle() {
    const [alertProperties, setAlertProperties] = useState({ visible: false, type: '', title: '', text: '' });
    function registerEntry() {
        let cadastrou = false; //Variavel criada apenas para testar 
        if (cadastrou) {
            setAlertProperties({ visible: true, type: 'sucess', title: 'Sucesso', text: 'O veículo de placa xxxxxx foi cadastrado a entrada com sucesso!' });
        } else {
            setAlertProperties({ visible: true, type: 'error', title: 'Erro', text: 'Erro ao cadastrar entrada do veículo' });
        }

        setTimeout(() => {
            setAlertProperties({ visible: false, type: '', title: '', text: '' });
        }, 8000);
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
                        <div className=" grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Placa" placeholder="" required={true} />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Modelo" placeholder="" />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Cor" placeholder="" />
                            <Input type="datetime-local" name="cliente" id="cliente" autoComplete="off" label="Data/Hora Entrada" placeholder="" required={true} />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Cliente" placeholder="" />

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

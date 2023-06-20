import React, { useState } from 'react';
import Input from "../components/Input"
import Button from "../components/Button"
import ButtonTransparent from "../components/ButtonTransparent"
import Alert from '../components/Alert';




export default function RegisterClient() {
    const [alertProperties, setAlertProperties] = useState({ visible: false, type: '', title: '', text: '' });
    function registerEntry() {
        let cadastrou = false; //Variavel criada apenas para testar 
        if (cadastrou) {
            setAlertProperties({ visible: true, type: 'sucess', title: 'Sucesso', text: 'O cliente foi cadastrado a entrada com sucesso!' });
        } else {
            setAlertProperties({ visible: true, type: 'error', title: 'Erro', text: 'Erro ao cadastrar o cliente' });
        }

        setTimeout(() => {
            setAlertProperties({ visible: false, type: '', title: '', text: '' });
        }, 8000);
    }
    return (
        <div className="duration-300">
            {alertProperties.visible && <Alert {...alertProperties} />}
            <div className="pb-8">
                <h1 className="text-2xl font-semibold">Registrar Cliente</h1>
            </div>
            <form>
                <div className="space-y-12">
                    <div className="border-b border-gray-900/10 pb-12">
                        <div className=" grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
                            <Input type="text" name="nomeCompleto" id="nomeCompleto" autoComplete="off" label="Nome Completo" placeholder="" required={true} />
                            <Input type="text" name="telefone" id="telefone" autoComplete="off" label="Telefone" placeholder="" />
                            <Input type="text" name="email" id="email" autoComplete="off" label="E-mail" placeholder="" />
                            <Input type="text" name="endereco" id="endereco" autoComplete="off" label="Endereço" placeholder="" />

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

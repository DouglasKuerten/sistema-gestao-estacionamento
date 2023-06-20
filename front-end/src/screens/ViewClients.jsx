import React, { useState } from 'react';
import { BsTrashFill } from "react-icons/bs"


const ClientesCadastrados = [
    {
        "id": 123456,
        "nome": "João da Silva",
        "telefone": "1234567890",
        "email": "joao@example.com",
        "endereco": "Rua das Flores, 123",
        "veiculos": [
            "ABC1231",
            "ABC1232",
            "ABC1233",
            "ABC1234",
            "ABC1235",
            "ABC1236",
            "ABC1237",
            "ABC1238",
            "ABC1239",
            "DEF5678"
        ]
    },
    {
        "id": 2,
        "nome": "Maria Souza",
        "telefone": "9876543210",
        "email": "maria@example.com",
        "endereco": "Avenida dos Sonhos, 456",
        "veiculos": [
            "GHI9012"
        ]
    },
    {
        "id": 3,
        "nome": "Carlos Oliveira",
        "telefone": "5555555555",
        "email": "carlos@example.com",
        "endereco": "Rua das Palmeiras, 789",
        "veiculos": [
            "JKL3456",
            "MNO7890"
        ]
    },
    {
        "id": 4,
        "nome": "Ana Rodrigues",
        "telefone": "9999999999",
        "email": "ana@example.com",
        "endereco": "Travessa das Flores, 10",
        "veiculos": []
    },
    {
        "id": 5,
        "nome": "Pedro Santos",
        "telefone": "1111111111",
        "email": "pedro@example.com",
        "endereco": "Rua dos Lírios, 234",
        "veiculos": [
            "PQR1234",
            "STU5678",
            "VWX9012",
            "VWX9002"

        ]
    }
];

export default function ViewClients() {
    function calcularTempoDecorrido(dataEntrada) {
        var dataAtual = new Date();
        var diferenca = dataAtual - new Date(dataEntrada);
        return '1 Dia, 3 horas';
    }

    const calcularPreco = (dataEntrada) => {
        let preco = 100;
        return preco.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
    };

    const [showPlacas, setShowPlacas] = useState(false);
    const handleMouseEnter = () => {
        setShowPlacas(true);
    };
    const handleMouseLeave = () => {
        setShowPlacas(false);
    };

    return (
        <div className="duration-300">
            <div className="pb-8">
                <h1 className="text-2xl font-semibold">Lista de Clientes</h1>
            </div>
            <div className="w-full mb-4 px-4 mx-auto mt-2">
                <div className="flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded ">
                    <div className="rounded-t mb-0 px-4 py-3 border-0">
                        <div className="flex flex-wrap items-center">
                            <div className="relative w-full px-4 max-w-full flex-grow flex-1">
                                <h3 className="font-semibold text-base text-blueGray-700">Titulo da listagem</h3>
                            </div>
                            <div className="relative w-full px-4 max-w-full flex-grow flex-1 text-right">
                                <button className="bg-blue-500 text-white active:bg-blue-600 text-xs font-bold uppercase px-3 py-1 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">Filtros</button>
                            </div>
                        </div>
                    </div>

                    <div className="block w-full overflow-x-auto rounded-md max-w-full">
                        <table className="items-center bg-transparent w-full border-collapse max-w-full">
                            <thead >
                                <tr >
                                    <th className="pl-6 pr-2 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Código
                                    </th>
                                    <th className="px-2 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Nome
                                    </th>
                                    <th className="px-2 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Telefone
                                    </th>
                                    <th className="px-2 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        E-mail
                                    </th>
                                    <th className="px-2 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Endereço
                                    </th>
                                    <th className="px-2 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Veículos
                                    </th>
                                    <th className="px-2 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">

                                    </th>
                                </tr>
                            </thead>

                            <tbody>
                                {ClientesCadastrados.map((cliente, index) => (
                                    <tr key={index}>
                                        <td className="border-t-0 pl-6 pr-2 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap py-4 text-left">
                                            {cliente.id}
                                        </td>
                                        <td className="border-t-0 px-2 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">
                                            {cliente.nome}
                                        </td>
                                        <td className="border-t-0 px-2 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            {cliente.telefone}
                                        </td>
                                        <td className="border-t-0 px-2 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            {cliente.email}
                                        </td>
                                        <td className="border-t-0 px-2 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            {cliente.endereco}
                                        </td>
                                        <td className="border-t-0 px-2 align-center border-l-0 border-r-0 text-xs p-4 whitespace-nowrap">
                                            <span className={`flex group relative cursor-pointer flex-col lg:w-52 `}>
                                                <span className='overflow-hidden whitespace-nowrap text-ellipsis'>
                                                    {cliente.veiculos.join(', ')}
                                                </span>
                                                <span className="flex absolute top-5 whitespace-pre-wrap max-w-full z-10 scale-0 rounded bg-gray-200 p-1.5 text-xs text-gray-700 group-hover:scale-100">{cliente.veiculos.join(', ')}</span>
                                            </span >
                                        </td>
                                        <td className="right-14 bg-white tborder-t-0 px-2 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-1.5 max-w-xl">
                                            <button className="bg-red-500 text-white active:bg-red-600 text-base uppercase p-1.5 rounded outline-none focus:outline-none mr-1 ease-linear transition-all duration-150" type="button"><BsTrashFill></BsTrashFill></button>

                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                        <div className='flex h-5 w-auto bg-gray-200 text-xs justify-end items-center pr-2'> {" "}</div>
                    </div>
                </div>
            </div>
            <footer className="flex flex-wrap items-center justify-center">
                <div className="w-full px-1 mx-auto text-center">
                    <div className="text-sm text-blueGray-500 font-semibold py-1">
                        <a>Rodapé / Navegação páginas</a>
                    </div>
                </div>
            </footer>
        </div>
    );
}

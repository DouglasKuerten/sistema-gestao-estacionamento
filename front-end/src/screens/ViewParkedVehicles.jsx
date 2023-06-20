import React, { useState } from 'react';

const VeiculosEstacionados = [
    {
        placa: 'MXT-0123',
        dataEntrada: '01/01/2020 07:59',
        modelo: 'Civic',
        cor: 'Cinza Espacial',
        tipoVeiculo: 'Carro',
        cliente: '',
        vaga: 132,
    },
    {
        placa: 'ABC-4567',
        dataEntrada: '02/03/2022 12:30',
        modelo: 'Corolla',
        cor: 'Branco Pérola',
        tipoVeiculo: 'Carro',
        cliente: 'João Silva',
        vaga: 215,
    },
    {
        placa: 'XYZ-7890',
        dataEntrada: '12/06/2023 09:45',
        modelo: 'Golf',
        cor: 'Preto',
        tipoVeiculo: 'Carro',
        cliente: 'Maria Santos',
        vaga: 304,
    },
    {
        placa: 'QWE-1234',
        dataEntrada: '10/09/2021 18:20',
        modelo: 'HB20',
        cor: 'Prata',
        tipoVeiculo: 'Carro',
        cliente: 'Pedro Oliveira',
        vaga: 421,
    },
    {
        placa: 'JKL-5678',
        dataEntrada: '07/04/2023 15:10',
        modelo: 'Fiesta',
        cor: 'Vermelho',
        tipoVeiculo: 'Carro',
        cliente: 'Ana Souza',
        vaga: 523,
    },
];

export default function ViewParkedVehicles() {
    function calcularTempoDecorrido(dataEntrada) {
        var dataAtual = new Date();
        var diferenca = dataAtual - new Date(dataEntrada);
        return '1 Dia, 3 horas';
    }

    const calcularPreco = (dataEntrada) => {
        let preco = 100;
        return preco.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });;
    };
    return (
        <div className="duration-300">
            <div className="pb-8">
                <h1 className="text-2xl font-semibold">Veículos Estacionados</h1>
            </div>
            <div class="w-full mb-4 px-4 mx-auto mt-2 ">
                <div class="flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded ">
                    <div class="rounded-t mb-0 px-4 py-3 border-0">
                        <div class="flex flex-wrap items-center">
                            <div class="relative w-full px-4 max-w-full flex-grow flex-1">
                                <h3 class="font-semibold text-base text-blueGray-700">Titulo da listagem</h3>
                            </div>
                            <div class="relative w-full px-4 max-w-full flex-grow flex-1 text-right">
                                <button class="bg-blue-500 text-white active:bg-blue-600 text-xs font-bold uppercase px-3 py-1 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">Filtros</button>
                            </div>
                        </div>
                    </div>

                    <div class="block w-full overflow-x-auto">
                        <table class="items-center bg-transparent w-full border-collapse ">
                            <thead>
                                <tr>
                                    <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Placa
                                    </th>
                                    <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Modelo
                                    </th>
                                    <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Data Entrada
                                    </th>
                                    <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Tempo Decorrido
                                    </th>
                                    <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Valor Atual
                                    </th>
                                    <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Cliente
                                    </th>
                                    <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Vaga
                                    </th>

                                </tr>
                            </thead>

                            <tbody>
                                {VeiculosEstacionados.map((veiculo, index) => (
                                    <tr key={index}>
                                        <td class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">
                                            {veiculo.placa}
                                        </td>
                                        <td class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">
                                            {veiculo.modelo}
                                        </td>
                                        <td class="border-t-0 px-6 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            {veiculo.dataEntrada}
                                        </td>
                                        <td class="border-t-0 px-6 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            {calcularTempoDecorrido(veiculo.dataEntrada)}
                                        </td>
                                        <td class="border-t-0 px-6 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            <i class="fas fa-arrow-up text-emerald-500 mr-1">R$</i>
                                            {calcularPreco(veiculo.dataEntrada)}
                                        </td>
                                        <td class="border-t-0 px-6 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            {veiculo.cliente}
                                        </td>
                                        <td class="border-t-0 px-6 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            {veiculo.vaga}
                                        </td>
                                    </tr>
                                )
                                )}
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
            <footer class="flex flex-wrap items-center justify-center">
                <div class="w-full px-1 mx-auto text-center">
                    <div class="text-sm text-blueGray-500 font-semibold py-1">
                        <a>Rodapé / Navegação páginas</a>
                    </div>
                </div>
            </footer>
        </div>
    )
}

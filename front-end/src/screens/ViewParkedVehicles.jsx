import React, { useState, useEffect } from 'react';
import axios from 'axios';
import moment from "moment";
import 'moment/locale/pt-br'
moment.locale('pt-br')

export default function ViewParkedVehicles() {
    const [databaseValues, setDatabaseValues] = useState([]);
    useEffect(() => {
        axios.get(import.meta.env.VITE_DB_URL + 'veiculosEstacionados')
            .then(response => {
                const data = response.data;
                setDatabaseValues(data);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    return (
        <div className="duration-300">
            <div className="pb-8">
                <h1 className="text-2xl font-semibold">Veículos Estacionados</h1>
            </div>
            <div className="w-full mb-4 px-4 mx-auto mt-2 ">
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

                    <div className="block w-full overflow-x-auto">
                        <table className="items-center bg-transparent w-full border-collapse ">
                            <thead>
                                <tr>
                                    <th className="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Placa
                                    </th>
                                    <th className="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Modelo
                                    </th>
                                    <th className="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Data Entrada
                                    </th>
                                    <th className="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Cliente
                                    </th>
                                    <th className="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                        Bloco
                                    </th>

                                </tr>
                            </thead>

                            <tbody>
                                {databaseValues.map((veiculo, index) => (
                                    <tr key={index}>
                                        <td className="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">
                                            {veiculo.DS_PLACA}
                                        </td>
                                        <td className="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">
                                            {veiculo.DS_MODELO}
                                        </td>
                                        <td className="border-t-0 px-6 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            {moment(veiculo.DT_INICIO).format('DD/MM/YYYY HH:MM')}
                                        </td>
                                        <td className="border-t-0 px-6 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            {veiculo.ID_CLIENTE}
                                        </td>
                                        <td className="border-t-0 px-6 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                            {veiculo.ID_BLOCO}
                                        </td>
                                    </tr>
                                )
                                )}
                            </tbody>

                        </table>
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
    )
}

import React from 'react';
import { PDFViewer } from '@react-pdf/renderer';
import Button from '../components/Button';
import { Fragment, useState } from 'react'
import { Dialog, Transition } from '@headlessui/react'
import DayParking from '../reports/DayParking';
import RankVehiclesParked from '../reports/RankVehiclesParked'
import Input from '../components/Input'
import Alert from '../components/Alert';

export default function Report() {
    const [open, setOpen] = useState(false)
    const [report, setReport] = useState({
        titulo: "",
        report: ""
    });
    const [filtersValues, setFiltersValues] = useState({ dataInicio: null, dataFim: null });
    const [alertVisible, setAlertVisible] = useState(false);
    const Reports = [
        {
            titulo: "Relatório de Veículos (Exemplo)",
            arquivo: <DayParking />
        },
        {
            titulo: "Ranking de Horas Estacionadas",
            arquivo: <RankVehiclesParked filterValues={filtersValues} />
        }]

    function validarFiltrosInformados(rep) {
        if (filtersValues.dataFim == null || filtersValues.dataInicio == null) {
            setAlertVisible(true);
            setTimeout(() => {
                setAlertVisible(false);
            }, 8000);
            return;
        } else {
            setAlertVisible(false);
        }

        setOpen(true);
        setReport({ titulo: rep.titulo, relatorio: rep.arquivo });
    }

    return (
        <div className='duration-300'>
            {alertVisible && <Alert visible={true} type={'error'} title={'Erro'} text={'Os filtros "Data início" e "Data Fim" devem ser informados para gerar o relatório'} />}
            <h3 className='font-bold text-lg mb-5'>
                Filtros
            </h3>
            <div className=" grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6 mb-5">
                <Input type="date" name="cliente" id="cliente" autoComplete="off" label="Data Início" placeholder="" obrigatory={'YES'} onChange={(value) => setFiltersValues({ ...filtersValues, dataInicio: value.target.value })} />
                <Input type="date" name="cliente" id="cliente" autoComplete="off" label="Data Fim" placeholder="" obrigatory={'YES'} onChange={(value) => setFiltersValues({ ...filtersValues, dataFim: value.target.value })} />

            </div>
            <div className=" grid grid-cols-3 gap-x-6 gap-y-8 mb-5">
                {Reports.map((rep, index) =>
                    <Button key={index} onClick={() => validarFiltrosInformados(rep)}>{rep.titulo}</Button>
                )}
            </div>
            <Transition.Root show={open} as={Fragment}>
                <Dialog as="div" className="relative z-10" onClose={() => setOpen(false)}>
                    <Transition.Child
                        as={Fragment}
                        enter="ease-out duration-300"
                        enterFrom="opacity-0"
                        enterTo="opacity-100"
                        leave="ease-in duration-300"
                        leaveFrom="opacity-100"
                        leaveTo="opacity-0">
                        <div className="fixed inset-0 bg-gray-200 bg-opacity-75 transition-opacity" />
                    </Transition.Child>

                    <div className=" fixed inset-0 z-10 overflow-y-hidden px-20 my-20">
                        <div className="flex h-full items-end justify-center text-center">
                            <Transition.Child
                                as={Fragment}
                                enter="ease-out duration-300"
                                enterFrom="opacity-0 translate-y-4 sm:translate-y-0 sm:scale-95"
                                enterTo="opacity-100 translate-y-0 sm:scale-100"
                                leave="ease-in duration-200"
                                leaveFrom="opacity-100 translate-y-0 sm:scale-100"
                                leaveTo="opacity-0 translate-y-4 sm:translate-y-0 sm:scale-95"
                            >
                                <Dialog.Panel className="flex flex-col h-full w-full max-w-5xl transform overflow-hidden rounded-lg bg-white text-left shadow-xl transition-all">
                                    <div className="flex flex-col w-full h-full text-center bg-white px-4 pt-5">
                                        <Dialog.Title as="h3" className="text-base font-semibold leading-6 text-gray-900">
                                            {report.titulo}
                                        </Dialog.Title>
                                        <PDFViewer className='flex h-full w-full p-5'>
                                            {report.relatorio}
                                        </PDFViewer>
                                    </div>
                                    <div className="flex w-full justify-end bg-white px-9 pb-4">
                                        <Button type="button" onClick={() => setOpen(false)}>Fechar</Button>
                                    </div>
                                </Dialog.Panel>
                            </Transition.Child>
                        </div>
                    </div>
                </Dialog>
            </Transition.Root>
        </div>
    )
}
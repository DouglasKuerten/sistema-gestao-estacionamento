import React from 'react';
import { PDFViewer } from '@react-pdf/renderer';
import Button from '../components/Button';
import { Fragment, useState } from 'react'
import { Dialog, Transition } from '@headlessui/react'
import DayParking from '../reports/DayParking';

export default function Report() {
    const [open, setOpen] = useState(false)

    //como acessar a api
    //console.log(axios.get('http://localhost:5555/users')
    //.then(response => {
    //  const data = response.data;
    //  console.log(data);
    // })
    //.catch(error => {
   //console.error(error);
   // }));

    return (
        <div >
            <Button onClick={() => setOpen(true)}>Relatório de Veículos</Button>
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
                                            Relatório de Veículos
                                        </Dialog.Title>
                                        <PDFViewer className='flex h-full w-full p-5'>
                                            <DayParking />
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

import { useState } from "react";
import EntryVehicle from "./screens/EntryVehicle";
import ExitVehicle from "./screens/ExitVehicle";
import PaymentVehicle from "./screens/PaymentVehicle";
import { BsArrowLeftShort, BsXCircle, BsPinFill, BsExclamationCircle, BsBookmarkPlus, BsPersonBadge, BsBookmarkDash, BsCashCoin, BsPeople, BsFiletypePdf, BsGear } from "react-icons/bs"
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom";
import NotFound from "./screens/NotFound";

export default function App() {
  const [open, setOpen] = useState(true);
  const Menus = [
    { title: "Entrada Veículo", icon: <BsBookmarkPlus />, href: "/entradaVeiculo" },
    { title: "Saída Veículo", icon: <BsBookmarkDash />, href: "/saidaVeiculo" },
    { title: "Preços", spacing: true, icon: <BsCashCoin />, href: "/precos" },
    { title: "Funcionários", spacing: true, icon: <BsPersonBadge />, href: "/funcionarios" },
    { title: "Clientes", icon: <BsPeople /> },
    { title: "Relatorio", spacing: true, icon: <BsFiletypePdf /> },
    { title: "Configurações", icon: <BsGear />, spacing: true },
    { title: "Sair", icon: <BsXCircle /> },
  ]
  return (
    <Router>
      <main>
        <div className="flex bg-slate-50">
          <div className={`flex flex-col align-middle justify-content-center h-auto bg-white border-r-2 border-r-slate-100 ${open ? "w-72" : "w-20"} duration-300 relative`}>
            <BsArrowLeftShort className={`text-black text-4xl bg-white rounded-full absolute -right-4 top-2 cursor-pointer ${!open && "rotate-180"} p-1.5`} onClick={() => setOpen(!open)} />
            <div className={`flex items-center px-3 mt-8 mb-4 ${!open ? "justify-center" : "justify-start pl-5"}`}>
              <BsPinFill className={`bg-blue-600 text-white text-5xl p-2 rounded cursor-pointer float-left duration-500 z-10 ${open && "rotate-[360deg] "}`} />
              <h1 className={`text-gray-700 origin-left font-medium text-2xl pl-3 duration-300 whitespace-nowrap ${!open && "scale-0 hidden"}`}>
                Parking
              </h1>
            </div>
            <ul className="flex flex-col px-5">
              {Menus.map((menu, index) =>
              (
                <li key={index} className={`flex flex-row ${!open ? "justify-center" : "justify-start"} text-gray-500  items-center gap-x-3 cursor-pointer hover:bg-blue-600 hover:text-white rounded-md ${menu.spacing ? "mt-9" : "mt-2"}`}>
                  <Link to={menu.href} className={`flex flex-row ${!open ? "justify-center" : "justify-start"} gap-x-3 items-center px-2.5 py-1`}>
                    <span className="text-xl py-1 block float-left duration-300 font-medium ">
                      {menu.icon ? menu.icon : <BsExclamationCircle />}
                    </span>
                    <span className={`text-base text-md font-medium whitespace-nowrap ${!open ? "scale-0 hidden" : "scale-100"} duration-300`}>{menu.title}</span>
                  </Link>
                </li >
              )
              )}

            </ul>
          </div>
          <div className="flex flex-col h-screen w-screen overflow-auto p-10" >
            <Routes>
              <Route path="/" element={<EntryVehicle />} />
              <Route path="/entradaVeiculo" element={<EntryVehicle />} />
              <Route path="/saidaVeiculo" element={<ExitVehicle />} />
              <Route path="/saidaVeiculo/resumoPagamentoVeiculo" element={<PaymentVehicle />} />


              <Route path="*" element={<NotFound />} />
            </Routes>
          </div>
        </div>

      </main>
    </Router >
  )
}
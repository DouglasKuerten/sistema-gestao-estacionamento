
import { useState } from "react";
import EntryVehicle from "./screens/EntryVehicle";
import ExitVehicle from "./screens/ExitVehicle";
import PaymentVehicle from "./screens/PaymentVehicle";
import { BsArrowLeftShort, BsXCircle, BsPinFill, BsExclamationCircle, BsBookmarkPlus, BsPersonBadge, BsBookmarkDash, BsCashCoin, BsPeople, BsFiletypePdf, BsGear, BsCarFront } from "react-icons/bs"
import { BrowserRouter as Router, Route, NavLink, Routes } from "react-router-dom";
import NotFound from "./screens/NotFound";
import Report from "./screens/Report";
import UnderDevelopment from "./screens/UnderDevelopment";
import ParkedVehicles from "./screens/ParkedVehicles";


export default function App() {
  const [open, setOpen] = useState(true);

  const Menus = [
    { title: "Entrada Veículo", icon: <BsBookmarkPlus />, href: "/entradaVeiculo" },
    { title: "Saída Veículo", icon: <BsBookmarkDash />, href: "/saidaVeiculo" },
    { title: "Veículos Estacionados", icon: <BsCarFront />, href: "/veiculosEstacionados" },
    { title: "Preços", spacing: true, icon: <BsCashCoin />, href: "/precos" },
    { title: "Funcionários", spacing: true, icon: <BsPersonBadge />, href: "/funcionarios" },
    { title: "Clientes", icon: <BsPeople />, href: "/clientes" },
    { title: "Relatorio", spacing: true, icon: <BsFiletypePdf />, href: "/relatorio" },
    { title: "Configurações", icon: <BsGear />, spacing: true, href: "/configuracoes" },
    { title: "Sair", icon: <BsXCircle />, href: "" },
  ]
  return (
    <Router>
      <main>
        <div className="flex bg-slate-50">
          <div className={`flex flex-col align-middle justify-content-center h-auto bg-white border-r-2 border-r-slate-100 ${open ? "w-72" : "w-20"} duration-300 relative`}>
            <BsArrowLeftShort className={`text-black text-4xl bg-white rounded-full absolute -right-4 top-2 cursor-pointer ${!open && "rotate-180"} p-1.5`} onClick={() => setOpen(!open)} />
            <div className={`flex items-center px-3 mt-8 mb-4 ${!open ? "justify-center" : "justify-start pl-5"}`}>
              <BsPinFill className={`z-10 bg-blue-600 text-white text-5xl p-2 rounded cursor-pointer float-left duration-500 ${open && "rotate-[360deg] "}`} />
              <h1 className={`text-gray-700 origin-left font-medium text-2xl pl-3 duration-300 whitespace-nowrap ${!open && "scale-0 hidden"}`}>
                Parking
              </h1>
            </div>
            <ul className="flex flex-col px-5">
              {Menus.map((menu, index) =>
              (
                <li key={index} className={`flex flex-row ${!open ? "justify-center" : "justify-start"}   items-center gap-x-3 cursor-pointer hover:bg-blue-600 hover:text-white rounded-md text-gray-500 ${menu.spacing ? "mt-9" : "mt-2"}`}>
                  <NavLink to={menu.href} className={({ isActive, isPending }) => `group flex flex-row ${!open ? "justify-center" : "justify-start"} gap-x-3 items-center px-2.5 py-1  ${isPending ? 'text-gray-500 ' : isActive ? 'text-blue-500 font-extrabold hover:text-white' : ''} `}>
                    <span className="flex align-middle text-xl py-1 float-left duration-300 font-medium ">
                      {!open && <span className="-my-1.5 ml-14 absolute scale-0 rounded whitespace-nowrap bg-gray-200 p-2 text-xs text-gray-700 group-hover:scale-100">{menu.title}</span>}
                      {menu.icon ? menu.icon : <BsExclamationCircle />}
                    </span>
                    <span className={`text-base text-md font-medium whitespace-nowrap ${!open ? "scale-0 hidden" : "scale-100"} duration-300`}>{menu.title}</span>


                  </NavLink>
                </li >
              )
              )}

            </ul>
          </div>
          <div className="flex flex-col h-screen w-screen overflow-auto p-10" >
            <Routes>
              <Route path="/" />
              <Route path="/entradaVeiculo" element={<EntryVehicle />} />
              <Route path="/saidaVeiculo" element={<ExitVehicle />} />
              <Route path="/veiculosEstacionados" element={<ParkedVehicles />} />
              <Route path="/saidaVeiculo/resumoPagamentoVeiculo" element={<PaymentVehicle />} />
              <Route path="/precos" element={<UnderDevelopment />} />
              <Route path="/funcionarios" element={<UnderDevelopment />} />
              <Route path="/clientes" element={<UnderDevelopment />} />
              <Route path="/configuracoes" element={<UnderDevelopment />} />

              <Route path="/relatorio" element={<Report />} />


              <Route path="*" element={<NotFound />} />
            </Routes>
          </div>
        </div>
      </main>
    </Router >
  )
}
export default function Input(props) {
    return (
        <div className="sm:col-span-4">
            <label htmlFor="username" className="block text-sm font-medium leading-6 text-gray-900">
                {props.label}
            </label>
            <div className="mt-2">
                <input
                    type={props.type}
                    name={props.name}
                    id={props.id}
                    autoComplete={props.autoComplete}
                    className="block w-full rounded-md border-0 p-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:ring-inset focus:ring-blue-600  sm:text-sm sm:leading-6"
                    placeholder={props.placeholder}
                    {...props}
                />
            </div>
        </div>)
}



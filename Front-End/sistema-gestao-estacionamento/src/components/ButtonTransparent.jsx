export default function ButtonTransparent(props) {
    return (
        <button
            type={props.type}
            {...props}
            className="text-sm font-semibold leading-6 text-gray-900">
            {props.children}
        </button>)
}

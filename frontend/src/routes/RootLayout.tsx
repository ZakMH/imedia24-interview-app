import { Link, Outlet } from "react-router-dom";

export function RootLayout() {
  return (
    <div className="container bg-slate-100 min-h-screen py-4 space-y-4">
      <header className="flex justify-between items-center bg-white rounded-md shadow-sm px-4 py-2">
        <Link to={"/"}>
          <h1 className="font-bold text-xl">LOGO</h1>
        </Link>
        <nav>
          <ul className="flex gap-4 items-center">
            <li className="p-2">
              <p className="p-2 hover:bg-slate-50 rounded-md">category 1</p>
            </li>
            <li className="p-2">
              <p className="p-2 hover:bg-slate-50 rounded-md">category 2</p>
            </li>
            <li className="p-2">
              <p className="p-2 hover:bg-slate-50 rounded-md">category 3</p>
            </li>
          </ul>
        </nav>
      </header>
      <main className="h-full p-4">
        <Outlet />
      </main>
    </div>
  );
}

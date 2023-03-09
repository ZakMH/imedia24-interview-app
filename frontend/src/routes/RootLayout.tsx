import { Link, Outlet } from "react-router-dom";
import { Dropdown } from "../components/Dropdown";
import { useGetCategories } from "../hooks/useGetCategories";

export function RootLayout() {
  const { data } = useGetCategories();

  return (
    <div className="bg-slate-100">
      <div className="container min-h-screen py-4 space-y-4">
        <header className="flex justify-between items-center bg-white rounded-md shadow-sm px-4 py-2">
          <Link to={"/"}>
            <h1 className="font-bold text-xl">LOGO</h1>
          </Link>
          <nav>
            <nav>
              <ul className="flex gap-4 items-center">
                {data?.data?.map((category) => (
                  <Dropdown key={category.id} category={category} />
                ))}
              </ul>
            </nav>
          </nav>
        </header>
        <main className="h-full p-4">
          <Outlet />
        </main>
      </div>
    </div>
  );
}

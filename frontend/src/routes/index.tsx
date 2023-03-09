import { createBrowserRouter } from "react-router-dom";
import { HomePage, CategoryPage } from "../pages/";

export const router = createBrowserRouter([
  {
    path: "/",
    children: [
      {
        path: "/",
        element: <HomePage />,
      },
      {
        path: "categories/:categoryId",
        element: <CategoryPage />,
      },
    ],
  },
]);

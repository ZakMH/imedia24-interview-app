import { createBrowserRouter } from "react-router-dom";
import { HomePage, CategoryPage } from "../pages/";
import { RootLayout } from "./RootLayout";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
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

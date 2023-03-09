import { createBrowserRouter } from "react-router-dom";
import { HomePage, ProductsPage } from "../pages/";
import ErrorPage from "../pages/ErrorPage";
import { RootLayout } from "./RootLayout";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        element: <HomePage />,
      },
      {
        path: "/:categoryId",
        element: <ProductsPage />,
      },
    ],
  },
]);

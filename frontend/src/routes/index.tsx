import { createBrowserRouter } from "react-router-dom";
import { HomePage, ProductPage, ProductsPage } from "../pages/";
import ErrorPage from "../pages/Error";
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
      {
        path: "/:categoryId/:productId",
        element: <ProductPage />,
      },
    ],
  },
]);

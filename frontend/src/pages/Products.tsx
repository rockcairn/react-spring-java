import { Link } from 'react-router-dom';
import ProductList from '../components/product-list';

export default function Products() {
  return (
    <div className="w-full">
      <div className="flex w-full items-center justify-between">
        <h1 className="text-2xl">Products</h1>
      </div>
      <div className="mt-4 flex justify-end items-center justify-between gap-2 md:mt-8">
        <Link
          to="/create"
          className="flex h-10 items-center rounded-lg bg-blue-600 px-4 text-sm font-medium text-white transition-colors hover:bg-blue-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-blue-600"
        >
          New Product +
        </Link>
      </div>
      <ProductList />
    </div>
  );
}

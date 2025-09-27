import { Link } from 'react-router-dom';
import ProductList from '../components/product-list';

export default function Products() {
  return (
    <div style={{ padding: '1rem' }}>
      <h1>Products</h1>
      <div className="p-4">
        <Link
          to="/create"
          className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700"
        >
          + New Product
        </Link>
      </div>
      <ProductList />
    </div>
  );
}

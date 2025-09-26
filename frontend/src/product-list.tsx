import { useEffect, useState } from 'react';
import type { Product } from './types';

export default function ProductList() {
  
const [products, setProducts] = useState<Product[]>([]);   
const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("/api/products") // your Spring Boot endpoint
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json(); // 👈 this parses the JSON body
      })
      .then((data) => {
        console.log("Received data:", data);
        setProducts(data);
      })
      .catch((error) => {
        console.error("Fetch error:", error);
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading...</p>;

  // const products = [{id: 1, name: "hello"}, {id: 2, name: "world"}];
  return (
    <div className="mt-6 flow-root">
      <div className="inline-block min-w-full align-middle">
        <div className="rounded-lg bg-gray-50 p-2 md:pt-0">
          <div className="sm:overflow-visible overflow-x-auto">
            <table className="min-w-full text-gray-900">
              <thead className="rounded-lg text-left text-sm font-normal">
                <tr>
                  <th scope="col" className="px-4 py-5 font-bold sm:pl-6">
                    Rank
                  </th>
                  <th scope="col" className="px-4 py-5 font-bold sm:pl-6">
                    Name
                  </th>
                </tr>
              </thead>
              <tbody className="bg-white">
                {products.map((product, index) => (
                  <tr
                    key={product.id}
                    className="w-full border-b py-3 text-sm last-of-type:border-none [&:first-child>td:first-child]:rounded-tl-lg [&:first-child>td:last-child]:rounded-tr-lg [&:last-child>td:first-child]:rounded-bl-lg [&:last-child>td:last-child]:rounded-br-lg"
                  >
                    <td className="whitespace-nowrap px-3 py-3">{index + 1}</td>
                    <td className="whitespace-nowrap py-3 pl-6 pr-3">
                        <span className="hidden sm:inline">{product.name}</span>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}

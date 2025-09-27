import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

export default function CreateProductForm() {
  const [form, setForm] = useState({
    name: "",
  });

  const navigate = useNavigate();

  const handleChange = (e: any) => {
    const { name, value } = e.target;
    setForm((prev) => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();

    const product = {
      name: form.name
    };

    try {
      const response = await fetch("/api/products", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Accept": "application/json"
        },
        body: JSON.stringify(product)
      });

      if (response.ok) {
        navigate("/");
      } else {
        console.error("Failed to create product:", response.statusText);
      }
    } catch (err) {
      console.error("Error:", err);
    }
  };
  
  return (
    <form onSubmit={handleSubmit}>
      <div className="rounded-md bg-gray-50 p-4 md:p-6">
        
        {/* Product Name */}
        <div className="mb-4">
          <label for="product-name" className="mb-2 block text-sm font-medium">
            Product Name
          </label>
          <div className="relative mt-2 rounded-md">
            <div className="relative">
              <input
                id="product-name"
                name="name"
                type="string"
                placeholder="product name"
                className="peer block w-full rounded-md border border-gray-200 py-2 pl-10 text-sm outline-2 placeholder:text-gray-500"
                onChange={handleChange}
                required
              />
            </div>
          </div>
        </div>
      </div>
      <div className="mt-6 flex justify-end gap-4">
        <Link
          to="/"
          className="flex h-12 items-center rounded-lg bg-gray-100 px-4 text-md font-medium text-gray-600 transition-colors hover:bg-gray-200"
        >
          Cancel
        </Link>
        <button type="submit">Create Product</button>
      </div>
    </form>
  );
}

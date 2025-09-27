import Breadcrumbs from '../components/breadcrumbs';
import CreateProductForm from '../components/create-form';

export default function Create() {
  return (
    <main>
      <Breadcrumbs
        breadcrumbs={[
          { label: 'Products', href: '/' },
          {
            label: 'Create Product',
            href: '/create',
            active: true,
          },
        ]}
      />
      <CreateProductForm />
    </main>
  );
}

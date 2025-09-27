import { render, screen } from '@testing-library/react';
import { describe, expect, it } from 'vitest';
import Products from '../Products';
import { MemoryRouter } from 'react-router-dom';

describe('Products', () => {
  it('renders home or Products page', () => {
    render(<MemoryRouter><Products /></MemoryRouter>);
    expect( screen.getByRole('heading', { level: 1, name: 'Products' })).toBeDefined();
    expect(screen.getByRole('link', { name: 'New Product +' })).toBeDefined();
  });
});

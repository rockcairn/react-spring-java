CREATE TABLE products (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);

INSERT INTO products ("name") values ('Product A');
INSERT INTO products ("name") values ('Product B');
INSERT INTO products ("name") values ('Product C');
INSERT INTO products ("name") values ('Product D');
INSERT INTO products ("name") values ('Product E');
INSERT INTO products ("name") values ('Product F');
INSERT INTO products ("name") values ('Product G');
INSERT INTO products ("name") values ('Product H');
INSERT INTO products ("name") values ('Product I');
INSERT INTO products ("name") values ('Product J');
INSERT INTO products ("name") values ('Product K');


-- ALTER TABLE products
-- ADD COLUMN description VARCHAR(256),
-- ADD COLUMN keywords VARCHAR(256),
-- ADD COLUMN price MONEY;

-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.81 WHERE name = 'Product A';
-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.82 WHERE name = 'Product B';
-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.83 WHERE name = 'Product C';
-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.84 WHERE name = 'Product D';
-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.85 WHERE name = 'Product E';
-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.86 WHERE name = 'Product F';
-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.87 WHERE name = 'Product G';
-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.88 WHERE name = 'Product H';
-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.89 WHERE name = 'Product I';
-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.90 WHERE name = 'Product J';
-- UPDATE prodcuts SET description = 'Best Game Ever', keywords = 'Green, Black, Small parcts', price = 31.91 WHERE name = 'Product K';
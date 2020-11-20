INSERT INTO items (id, payload)
VALUES (1, '{
  "ref": "001",
  "name": "Tea",
  "price": 1.6,
  "description": "British Tea",
  "imageUrl": "http://weknowyourdreams.com/images/tea/tea-05.jpg",
  "estimatedCompletionTime": "2m"
}');

INSERT INTO items (id, payload)
VALUES (2, '{
  "ref": "002",
  "name": "Latte",
  "price": 2.4,
  "description": "Pumpkin Spice Latte",
  "imageUrl": "http://www.inspiredtaste.net/wp-content/uploads/2011/11/Pumpkin-Spice-Latte-Recipe-1200.jpg",
  "estimatedCompletionTime": "2m"
}');


INSERT INTO assignees(uid, name)
VALUES (1, 'Tom Table');

INSERT INTO assignees(uid, name)
VALUES (2, 'Alex Cup');

INSERT INTO customers(uid, name)
VALUES (1, 'John Field');

INSERT INTO customers(uid, name)
VALUES (2, 'Bob Plain');

DROP TABLE IF EXISTS RECIPE;
DROP TABLE IF EXISTS INGREDIENTS;
CREATE TABLE RECIPE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  creation_time VARCHAR(250) NOT NULL,
  last_updated VARCHAR(250) NOT NULL,
  vegetarian BOOLEAN DEFAULT TRUE,
  number_of_people_it_serves BIGINT,
  instructions VARCHAR(500),
  calories DOUBLE,
  protiens DOUBLE
);
CREATE TABLE INGREDIENTS (
  id INT AUTO_INCREMENT primary key,
  name VARCHAR(250),
  quantity_in_grams DOUBLE
);
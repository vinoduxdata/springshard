CREATE TABLE IF NOT EXISTS "categories" (
    "category_id" INTEGER PRIMARY KEY,
    "category_name" TEXT NOT NULL
);

INSERT INTO "categories" ("category_id", "category_name") VALUES ('1', 'Children Bicycles');
INSERT INTO "categories" ("category_id", "category_name") VALUES ('2', 'Comfort Bicycles');
INSERT INTO "categories" ("category_id", "category_name") VALUES ('3', 'Cruisers Bicycles');
INSERT INTO "categories" ("category_id", "category_name") VALUES ('4', 'Cyclocross Bicycles');
INSERT INTO "categories" ("category_id", "category_name") VALUES ('5', 'Electric Bikes');
INSERT INTO "categories" ("category_id", "category_name") VALUES ('6', 'Mountain Bikes');
INSERT INTO "categories" ("category_id", "category_name") VALUES ('7', 'Road Bikes');

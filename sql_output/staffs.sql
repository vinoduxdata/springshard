CREATE TABLE IF NOT EXISTS "staffs" (
    "staff_id" INTEGER PRIMARY KEY,
    "first_name" TEXT NOT NULL,
    "last_name" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "phone" TEXT,
    "active" INTEGER NOT NULL DEFAULT 1,
    "store_id" INTEGER NOT NULL,
    "manager_id" INTEGER,
    FOREIGN KEY ("manager_id") REFERENCES "staffs"("staff_id")
);

INSERT INTO "staffs" (
    "staff_id", "first_name", "last_name", "email", "phone", "active", "store_id", "manager_id"
) VALUES (
    '1', 'Fabiola', 'Jackson', 'fabiola.jackson@bikes.shop', '(831) 555-5554', '1', '1', NULL
);

INSERT INTO "staffs" ("staff_id", "first_name", "last_name", "email", "phone", "active", "store_id", "manager_id") VALUES ('2', 'Mireya', 'Copeland', 'mireya.copeland@bikes.shop', '(831) 555-5555', '1', '1', '1');
INSERT INTO "staffs" ("staff_id", "first_name", "last_name", "email", "phone", "active", "store_id", "manager_id") VALUES ('3', 'Genna', 'Serrano', 'genna.serrano@bikes.shop', '(831) 555-5556', '1', '1', '2');
INSERT INTO "staffs" ("staff_id", "first_name", "last_name", "email", "phone", "active", "store_id", "manager_id") VALUES ('4', 'Virgie', 'Wiggins', 'virgie.wiggins@bikes.shop', '(831) 555-5557', '1', '1', '2');
INSERT INTO "staffs" ("staff_id", "first_name", "last_name", "email", "phone", "active", "store_id", "manager_id") VALUES ('5', 'Jannette', 'David', 'jannette.david@bikes.shop', '(516) 379-4444', '1', '2', '1');
INSERT INTO "staffs" ("staff_id", "first_name", "last_name", "email", "phone", "active", "store_id", "manager_id") VALUES ('6', 'Marcelene', 'Boyer', 'marcelene.boyer@bikes.shop', '(516) 379-4445', '1', '2', '5');
INSERT INTO "staffs" ("staff_id", "first_name", "last_name", "email", "phone", "active", "store_id", "manager_id") VALUES ('7', 'Venita', 'Daniel', 'venita.daniel@bikes.shop', '(516) 379-4446', '1', '2', '5');
INSERT INTO "staffs" ("staff_id", "first_name", "last_name", "email", "phone", "active", "store_id", "manager_id") VALUES ('8', 'Kali', 'Vargas', 'kali.vargas@bikes.shop', '(972) 530-5555', '1', '3', '1');
INSERT INTO "staffs" ("staff_id", "first_name", "last_name", "email", "phone", "active", "store_id", "manager_id") VALUES ('9', 'Layla', 'Terrell', 'layla.terrell@bikes.shop', '(972) 530-5556', '1', '3', '7');
INSERT INTO "staffs" ("staff_id", "first_name", "last_name", "email", "phone", "active", "store_id", "manager_id") VALUES ('10', 'Bernardine', 'Houston', 'bernardine.houston@bikes.shop', '(972) 530-5557', '1', '3', '7');

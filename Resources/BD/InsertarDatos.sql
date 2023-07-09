-- SCRIPT 


-- Administrador

INSERT INTO administrador VALUES (1, 'laura', '123456789');
INSERT INTO administrador VALUES (2, 'cristopher', '123456789');

-- Cliente

INSERT INTO cliente VALUES (111111111, 'Maria', 'Paula', 'Gonzalez', 'Cuellar', '6666666', 'mpgc@correo.com', 'Calle 142 # 12 - 34', 'asd123');
INSERT INTO cliente VALUES (222222222, 'Brayan', 'David', 'Pinto', 'Castillo', '6666666', 'bdpc@correo.com', 'Calle 134 # 12 - 35', 'asd123');
INSERT INTO cliente VALUES (333333333, 'Jefferson', 'Alexander', 'Romero', 'Buitrago', '6666666', 'asdf@correo.com', 'Calle 134 # 12 - 35', 'asd123');

-- Especialidad

INSERT INTO especialidad VALUES (1, 'Gourmet');
INSERT INTO especialidad VALUES (2, 'De Especialidad');
INSERT INTO especialidad VALUES (3, 'Familiar');
INSERT INTO especialidad VALUES (4, 'Buffet');
INSERT INTO especialidad VALUES (5, 'Comida Rapida');
INSERT INTO especialidad VALUES (6, 'Temático');
INSERT INTO especialidad VALUES (7, 'Para llevar');

-- Ingredientes 

INSERT INTO ingrediente VALUES (1, 'Gaseosa Cocacola', 'Unidad');
INSERT INTO ingrediente VALUES (2, 'Gaseosa Colombiana', 'Unidad');
INSERT INTO ingrediente VALUES (3, 'Gaseosa Pepsi', 'Unidad');
INSERT INTO ingrediente VALUES (4, 'Gaseosa Canada Dry', 'Unidad');
INSERT INTO ingrediente VALUES (5, 'Carne de Hamburguesa', 'Unidad');
INSERT INTO ingrediente VALUES (6, 'Pollo de Hamburguesa', 'Unidad');
INSERT INTO ingrediente VALUES (7, 'Rodaja de Queso', 'Unidad');
INSERT INTO ingrediente VALUES (8, 'Rodaja de Jamón', 'Unidad');
INSERT INTO ingrediente VALUES (9, 'Tocineta', 'Unidad');
INSERT INTO ingrediente VALUES (10, 'Queso', 'Libra');
INSERT INTO ingrediente VALUES (11, 'Papa', 'Libra');
INSERT INTO ingrediente VALUES (12, 'Fritura de papa', 'Libra');
INSERT INTO ingrediente VALUES (13, 'Platano', 'Libra');
INSERT INTO ingrediente VALUES (14, 'Arroz', 'Libra');
INSERT INTO ingrediente VALUES (15, 'Lechuga', 'Libra');
INSERT INTO ingrediente VALUES (16, 'Carne', 'Libra');
INSERT INTO ingrediente VALUES (17, 'Pollo', 'Libra');
INSERT INTO ingrediente VALUES (18, 'Cerdo', 'Libra');
INSERT INTO ingrediente VALUES (19, 'Jamón', 'Libra');
INSERT INTO ingrediente VALUES (20, 'Cebolla', 'Libra');
INSERT INTO ingrediente VALUES (21, 'Tomate', 'Libra');
INSERT INTO ingrediente VALUES (22, 'Frijoles', 'Libra');
INSERT INTO ingrediente VALUES (23, 'Lentejas', 'Libra');
INSERT INTO ingrediente VALUES (24, 'Garbanzos', 'Libra');
INSERT INTO ingrediente VALUES (25, 'Pasta', 'Libra');
INSERT INTO ingrediente VALUES (26, 'Huevo', 'Unidad');
INSERT INTO ingrediente VALUES (27, 'Huevo de codorniz', 'Unidad');
INSERT INTO ingrediente VALUES (28, 'Mortadela', 'Libra');
INSERT INTO ingrediente VALUES (29, 'Salchicha', 'Unidad');
INSERT INTO ingrediente VALUES (30, 'Pan de hamburguesa', 'Unidad');
INSERT INTO ingrediente VALUES (31, 'Pan de perro caliente', 'Unidad');
INSERT INTO ingrediente VALUES (32, 'Empanada de carne', 'Unidad');
INSERT INTO ingrediente VALUES (33, 'Empanada de pollo', 'Unidad');
INSERT INTO ingrediente VALUES (34, 'Empanada de queso', 'Unidad');
INSERT INTO ingrediente VALUES (35, 'Empanada ranchera', 'Unidad');
INSERT INTO ingrediente VALUES (36, 'Empanada mexicana', 'Unidad');

-- Restaurante

INSERT INTO restaurante VALUES (1, 5, 'Los Rolitos', 'Calle 16 # 16 - 16', '987987987', 'rolitos', 'asd123', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1670262735/ROLOS%20DEV/descargar_terlwv.jpg');
INSERT INTO restaurante VALUES (2, 5, 'Laura´s PTE', 'Carrera 17 # 12 - 17', '987987987', 'lauritas', 'asd123', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1670262735/ROLOS%20DEV/L_fqd48y.png');
INSERT INTO restaurante VALUES (3, 3, 'Donde Rosita', 'Calle 170 # 30 - 40', '987987987', 'rositas', 'asd123', 'https://res.cloudinary.com/dn1k0drir/image/upload/v1670262735/ROLOS%20DEV/R_azoyvr.png');

-- Stock

INSERT INTO stock VALUES (1, 1, 1, 5);
INSERT INTO stock VALUES (2, 1, 2, 5);
INSERT INTO stock VALUES (3, 1, 3, 5);
INSERT INTO stock VALUES (4, 1, 4, 5);
INSERT INTO stock VALUES (5, 1, 5, 15);
INSERT INTO stock VALUES (6, 1, 6, 15);
INSERT INTO stock VALUES (7, 1, 7, 15);
INSERT INTO stock VALUES (8, 1, 8, 16);
INSERT INTO stock VALUES (9, 1, 9, 6);
INSERT INTO stock VALUES (10, 1, 10, 8);
INSERT INTO stock VALUES (11, 1, 12, 9);
INSERT INTO stock VALUES (12, 1, 13, 12);
INSERT INTO stock VALUES (13, 1, 15, 17);
INSERT INTO stock VALUES (14, 1, 16, 19);
INSERT INTO stock VALUES (15, 1, 17, 23);
INSERT INTO stock VALUES (16, 1, 18, 5);
INSERT INTO stock VALUES (17, 1, 20, 5);
INSERT INTO stock VALUES (18, 1, 21, 5);
INSERT INTO stock VALUES (19, 1, 27, 5);
INSERT INTO stock VALUES (20, 1, 28, 5);
INSERT INTO stock VALUES (21, 1, 29, 7);
INSERT INTO stock VALUES (22, 1, 11, 8);
INSERT INTO stock VALUES (54, 1, 30, 23);
INSERT INTO stock VALUES (55, 1, 31, 23);

INSERT INTO stock VALUES (23, 2, 1, 15);
INSERT INTO stock VALUES (24, 2, 2, 30);
INSERT INTO stock VALUES (25, 2, 3, 20);
INSERT INTO stock VALUES (26, 2, 4, 20);
INSERT INTO stock VALUES (27, 2, 5, 5);
INSERT INTO stock VALUES (28, 2, 6, 8);
INSERT INTO stock VALUES (29, 2, 7, 4);
INSERT INTO stock VALUES (30, 2, 8, 6);
INSERT INTO stock VALUES (31, 2, 9, 7);
INSERT INTO stock VALUES (32, 2, 12, 9);
INSERT INTO stock VALUES (33, 2, 15, 8);
INSERT INTO stock VALUES (34, 2, 20, 8);
INSERT INTO stock VALUES (35, 2, 21, 7);
INSERT INTO stock VALUES (36, 2, 29, 34);
INSERT INTO stock VALUES (56, 2, 30, 23);
INSERT INTO stock VALUES (57, 2, 31, 23);

INSERT INTO stock VALUES (37, 3, 1, 10);
INSERT INTO stock VALUES (38, 3, 2, 11);
INSERT INTO stock VALUES (39, 3, 10, 12);
INSERT INTO stock VALUES (40, 3, 11, 13);
INSERT INTO stock VALUES (41, 3, 13, 5);
INSERT INTO stock VALUES (42, 3, 15, 5);
INSERT INTO stock VALUES (43, 3, 16, 5);
INSERT INTO stock VALUES (44, 3, 17, 6);
INSERT INTO stock VALUES (45, 3, 18, 7);
INSERT INTO stock VALUES (46, 3, 19, 8);
INSERT INTO stock VALUES (47, 3, 20, 9);
INSERT INTO stock VALUES (48, 3, 21, 8);
INSERT INTO stock VALUES (49, 3, 22, 5);
INSERT INTO stock VALUES (50, 3, 23, 7);
INSERT INTO stock VALUES (51, 3, 24, 6);
INSERT INTO stock VALUES (52, 3, 25, 3);
INSERT INTO stock VALUES (53, 3, 26, 5);
INSERT INTO stock VALUES (58, 3, 32, 23);
INSERT INTO stock VALUES (59, 3, 33, 23);
INSERT INTO stock VALUES (60, 3, 34, 23);
INSERT INTO stock VALUES (61, 3, 35, 23);
INSERT INTO stock VALUES (62, 3, 36, 23);

-- Clasificacion

INSERT INTO clasificacion VALUES (1, 'Entrada');
INSERT INTO clasificacion VALUES (2, 'Plato Fuerte');
INSERT INTO clasificacion VALUES (3, 'Postre');
INSERT INTO clasificacion VALUES (4, 'Bebida');
INSERT INTO clasificacion VALUES (5, 'Acompañamiento');
INSERT INTO clasificacion VALUES (6, 'Comida Rápida');

-- Producto

INSERT INTO producto VALUES (1, 1, 4, 'Cocacola', 3000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086893/ROLOS%20DEV/1_-_Cocacola_wxbvfb.png');
INSERT INTO producto VALUES (2, 1, 4, 'Colombiana', 3000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086894/ROLOS%20DEV/2_-_Colombiana_nnfokf.png');
INSERT INTO producto VALUES (3, 1, 4, 'Pepsi', 3000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086894/ROLOS%20DEV/3_-_Pepsi_xehuis.png');
INSERT INTO producto VALUES (4, 1, 4, 'Canada Dry', 3000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086895/ROLOS%20DEV/4_-_Canada_Dry_o6huvj.png');
INSERT INTO producto VALUES (5, 1, 6, 'Hamburguesa de Carne', 12000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086896/ROLOS%20DEV/5_-_Hamburguesa_de_carne_j081do.png');
INSERT INTO producto VALUES (6, 1, 6, 'Hamburguesa de Pollo', 12000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086895/ROLOS%20DEV/6_-_Hamburguesa_de_pollo_yeb0bh.png');
INSERT INTO producto VALUES (7, 1, 6, 'Salchipapa', 10000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086896/ROLOS%20DEV/7_-_Salchipapas_touweh.png');
INSERT INTO producto VALUES (8, 1, 6, 'Perro Caliente', 11000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086898/ROLOS%20DEV/8_-_Perro_caliente_lg1dcq.png');

INSERT INTO producto VALUES (9, 2, 4, 'Cocacola', 4000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086895/ROLOS%20DEV/9_-_Cocacola_yuy37b.png');
INSERT INTO producto VALUES (10, 2, 4, 'Colombiana', 4000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086897/ROLOS%20DEV/10-_Colombiana_k0jpaw.png');
INSERT INTO producto VALUES (11, 2, 4, 'Pepsi', 4000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086896/ROLOS%20DEV/11_-_Pepsi_jivjh8.png');
INSERT INTO producto VALUES (12, 2, 4, 'Canada Dry', 4000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086899/ROLOS%20DEV/12_-_Canada_Dry_mdcndf.png');
INSERT INTO producto VALUES (13, 2, 6, 'Hamburguesa', 15000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086901/ROLOS%20DEV/13_-_Hamburguesa_enzyqo.png');
INSERT INTO producto VALUES (14, 2, 6, 'Perro caliente', 14000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086900/ROLOS%20DEV/14_-_Perro_caliente_qj0fus.png');

INSERT INTO producto VALUES (15, 3, 4, 'Cocacola', 3500, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086897/ROLOS%20DEV/15_-_Cocacola_giunzi.png');
INSERT INTO producto VALUES (16, 3, 4, 'Colombiana', 3500, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086898/ROLOS%20DEV/16_-_Colombiana_s5hucc.png');
INSERT INTO producto VALUES (17, 3, 1, 'Empanada de Carne', 2000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086900/ROLOS%20DEV/17_-_Empanada_de_carne_oqckvg.png');
INSERT INTO producto VALUES (18, 3, 1, 'Empanada de Pollo', 2000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086899/ROLOS%20DEV/18_-_empanada_de_pollo_uxbn13.png');
INSERT INTO producto VALUES (19, 3, 1, 'Empanada de Queso', 2000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086899/ROLOS%20DEV/19_-_Empanada_de_queso_jckws4.png');
INSERT INTO producto VALUES (20, 3, 1, 'Empanada Ranchera', 2000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086901/ROLOS%20DEV/20_-_Empanada_ranchera_rmsc2k.png');
INSERT INTO producto VALUES (21, 3, 1, 'Empanada Mexicana', 2000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086899/ROLOS%20DEV/21_-_Empanada_mexicana_rxvecz.png');
INSERT INTO producto VALUES (22, 3, 2, 'Corrientazo 1', 10000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086902/ROLOS%20DEV/22_-_Corrientazo_1_uzrkcx.png');
INSERT INTO producto VALUES (23, 3, 2, 'Corrientazo 2', 10000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086901/ROLOS%20DEV/23_-_Corrientazo_2_shows4.png');
INSERT INTO producto VALUES (24, 3, 2, 'Corrientazo 3', 10000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086901/ROLOS%20DEV/24_-_Corrientazo_3_mexzru.png');
INSERT INTO producto VALUES (25, 3, 2, 'Corrientazo 4', 10000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668086901/ROLOS%20DEV/25_-_Corrientazo_4_okn1mb.png');

-- producto_ingrediente

INSERT INTO producto_ingrediente VALUES (1, 1, 1, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (2, 2, 2, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (3, 3, 3, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (4, 4, 4, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (5, 5, 5, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (6, 30, 5, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (7, 7, 5, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (8, 8, 5, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (9, 9, 5, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (10, 12, 5, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (11, 15, 5, 0.1, TRUE);
INSERT INTO producto_ingrediente VALUES (12, 20, 5, 0.2, TRUE);
INSERT INTO producto_ingrediente VALUES (13, 21, 5, 0.2, TRUE);
INSERT INTO producto_ingrediente VALUES (14, 27, 5, 2, TRUE);
INSERT INTO producto_ingrediente VALUES (15, 6, 6, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (16, 30, 6, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (17, 7, 6, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (18, 8, 6, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (19, 9, 6, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (20, 12, 6, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (21, 15, 6, 0.1, TRUE);
INSERT INTO producto_ingrediente VALUES (22, 20, 6, 0.2, TRUE);
INSERT INTO producto_ingrediente VALUES (23, 21, 6, 0.2, TRUE);
INSERT INTO producto_ingrediente VALUES (24, 27, 6, 2, TRUE);
INSERT INTO producto_ingrediente VALUES (25, 11, 7, 0.5, FALSE);
INSERT INTO producto_ingrediente VALUES (26, 29, 7, 2, FALSE);
INSERT INTO producto_ingrediente VALUES (27, 10, 7, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (28, 9, 7, 2, FALSE);
INSERT INTO producto_ingrediente VALUES (29, 31, 8, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (30, 29, 8, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (31, 7, 8, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (32, 8, 8, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (33, 9, 8, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (34, 12, 8, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (35, 20, 8, 0.2, TRUE);
INSERT INTO producto_ingrediente VALUES (36, 21, 8, 0.2, TRUE);
INSERT INTO producto_ingrediente VALUES (37, 27, 8, 2, TRUE);

INSERT INTO producto_ingrediente VALUES (38, 1, 9, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (39, 2, 10, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (40, 3, 11, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (41, 4, 12, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (42, 5, 13, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (43, 30, 13, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (44, 7, 13, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (45, 8, 13, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (46, 9, 13, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (47, 12, 13, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (48, 15, 13, 0.1, TRUE);
INSERT INTO producto_ingrediente VALUES (49, 20, 13, 0.2, TRUE);
INSERT INTO producto_ingrediente VALUES (50, 21, 13, 0.2, TRUE);
INSERT INTO producto_ingrediente VALUES (51, 27, 13, 2, TRUE);
INSERT INTO producto_ingrediente VALUES (52, 31, 14, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (53, 29, 14, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (54, 7, 14, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (55, 8, 14, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (56, 9, 14, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (57, 12, 14, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (58, 20, 14, 0.2, TRUE);
INSERT INTO producto_ingrediente VALUES (59, 21, 14, 0.2, TRUE);
INSERT INTO producto_ingrediente VALUES (60, 27, 14, 2, TRUE);

INSERT INTO producto_ingrediente VALUES (61, 1, 15, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (62, 2, 16, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (63, 32, 17, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (64, 33, 18, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (65, 34, 19, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (66, 35, 20, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (67, 36, 21, 1, FALSE);
INSERT INTO producto_ingrediente VALUES (68, 22, 22, 0.3, FALSE);
INSERT INTO producto_ingrediente VALUES (69, 14, 22, 0.3, FALSE);
INSERT INTO producto_ingrediente VALUES (70, 13, 22, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (71, 11, 22, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (72, 26, 22, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (73, 16, 22, 0.5, TRUE);
INSERT INTO producto_ingrediente VALUES (74, 23, 23, 0.3, FALSE);
INSERT INTO producto_ingrediente VALUES (75, 14, 23, 0.3, FALSE);
INSERT INTO producto_ingrediente VALUES (76, 13, 23, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (77, 11, 23, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (78, 26, 23, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (79, 16, 23, 0.5, TRUE);
INSERT INTO producto_ingrediente VALUES (80, 24, 24, 0.3, FALSE);
INSERT INTO producto_ingrediente VALUES (81, 14, 24, 0.3, FALSE);
INSERT INTO producto_ingrediente VALUES (82, 13, 24, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (83, 11, 24, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (84, 26, 24, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (85, 17, 24, 0.5, TRUE);
INSERT INTO producto_ingrediente VALUES (86, 25, 25, 0.3, FALSE);
INSERT INTO producto_ingrediente VALUES (87, 14, 25, 0.3, FALSE);
INSERT INTO producto_ingrediente VALUES (88, 13, 25, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (89, 11, 25, 0.3, TRUE);
INSERT INTO producto_ingrediente VALUES (90, 26, 25, 1, TRUE);
INSERT INTO producto_ingrediente VALUES (91, 18, 25, 0.5, TRUE);

-- Menu

INSERT INTO menu VALUES (1, 1, 'Combo Hamburguesa', 14000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668087544/ROLOS%20DEV/1_-combo_hamburguesa_zg2oni.png');
INSERT INTO menu VALUES (2, 1, 'Combo Salchipapa', 12000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668087993/ROLOS%20DEV/2-_combo-salchipapas_lnzwj6.png');
INSERT INTO menu VALUES (3, 1, 'Combo Perro Caliente', 13000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668088261/ROLOS%20DEV/3-_combo-perrocaliente_edy24n.png');
INSERT INTO menu VALUES (4, 2, 'Combo Hamburguesa', 17500, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668088434/ROLOS%20DEV/4-_combo_hamburguesa2_klkoyd.png');
INSERT INTO menu VALUES (5, 2, 'Combo Perro Caliente', 16500, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668088924/ROLOS%20DEV/5-_combo-perrocaliente2_lluojs.png');
INSERT INTO menu VALUES (6, 3, 'Corrientazo Básico', 12500, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668089301/ROLOS%20DEV/6-corrientazo_trul4m.png');
INSERT INTO menu VALUES (7, 3, 'Corrientazo Full', 14000, 'https://res.cloudinary.com/dn1k0drir/image/upload/v1668089826/ROLOS%20DEV/7-_corrientazofull_chpxmt.pngs');

-- Selección Base

INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (1, 1, 6, 12000, 12000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (2, 1, 4, 3000, 3000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (3, 2, 6, 10000, 10000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (4, 2, 4, 3000, 3000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (5, 3, 6, 11000, 11000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (6, 3, 4, 3000, 3000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (7, 4, 6, 15000, 15000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (8, 4, 4, 4000, 4000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (9, 5, 6, 14000, 14000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (10, 5, 4, 4000, 4000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (11, 6, 2, 10000, 10000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (12, 6, 4, 3500, 3500);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (13, 7, 1, 2000, 2000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (14, 7, 2, 10000, 10000);
INSERT INTO seleccion(idseleccion, idmenu, idclasificacion, precio_bajo, precio_alto) VALUES (15, 7, 4, 3500, 3500);

-- Menu_Seleccionado

INSERT INTO menu_seleccionado VALUES (1, 1);
INSERT INTO menu_seleccionado VALUES (2, 1);
INSERT INTO menu_seleccionado VALUES (3, 1);
INSERT INTO menu_seleccionado VALUES (4, 2);
INSERT INTO menu_seleccionado VALUES (5, 3);

INSERT INTO menu_seleccionado VALUES (6, 4);
INSERT INTO menu_seleccionado VALUES (7, 6);

INSERT INTO menu_seleccionado VALUES (8, 7);
INSERT INTO menu_seleccionado VALUES (9, 7);
INSERT INTO menu_seleccionado VALUES (10, 7);
INSERT INTO menu_seleccionado VALUES (11, 3);

-- Seleccion (Menu_Seleccionado)

INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (16, 1, 6, 5);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (17, 1, 4, 4);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (18, 2, 6, 6);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (19, 2, 4, 3);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (20, 3, 6, 5);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (21, 3, 4, 2);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (22, 4, 6, 7);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (23, 4, 4, 1);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (24, 5, 6, 8);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (25, 5, 4, 4);

INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (26, 6, 6, 13);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (27, 6, 4, 10);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (28, 7, 2, 25);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (29, 7, 4, 16);

INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (30, 8, 1, 18);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (31, 8, 2, 22);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (32, 8, 4, 15);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (33, 9, 1, 19);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (34, 9, 2, 23);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (35, 9, 4, 15);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (36, 10, 1, 20);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (37, 10, 2, 24);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (38, 10, 4, 16);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (39, 11, 6, 8);
INSERT INTO seleccion(idseleccion, idmenu_seleccionado, idclasificacion, idproducto) VALUES (40, 11, 4, 4);

-- Tipo Tarjeta

INSERT INTO tipo_tarjeta(tipo, identificador) VALUES ('American Express', 3);
INSERT INTO tipo_tarjeta(tipo, identificador) VALUES ('Master Card', 4);
INSERT INTO tipo_tarjeta(tipo, identificador) VALUES ('Visa', 5);

-- Tarjeta

INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('333333333333337', 111, 'American Express', '2023-06-01');
INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('300000000000007', 111, 'American Express', '2023-06-01');
INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('310101010101013', 111, 'American Express', '2023-06-01');
INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('301010101010101', 111, 'American Express', '2023-06-01');

INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('4444444444444448', 111, 'Master Card', '2023-06-01');
INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('4010101010101018', 111, 'Master Card', '2023-06-01');
INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('4000000000000002', 111, 'Master Card', '2023-06-01');
INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('4101010101010105', 111, 'Master Card', '2023-06-01');

INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('5555555555555557', 111, 'Visa', '2023-06-01');
INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('5000000000000009', 111, 'Visa', '2023-06-01');
INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('5010101010101015', 111, 'Visa', '2023-06-01');
INSERT INTO tarjeta(numtarjeta, pin, tipo, fecha_caducidad) VALUES ('5101010101010102', 111, 'Visa', '2023-06-01');

-- Tarjetas Cliente

INSERT INTO tarjetas_cliente VALUES (111111111, '5101010101010102');
INSERT INTO tarjetas_cliente VALUES (111111111, '4101010101010105');
INSERT INTO tarjetas_cliente VALUES (222222222, '4101010101010105');
INSERT INTO tarjetas_cliente VALUES (333333333, '333333333333337');

-- Compra

INSERT INTO compra(idcompra, idcliente, pagaefectivo, total, fecha) VALUES (1, 111111111, TRUE, 89000, '8-11-2022');
INSERT INTO compra(idcompra, idcliente, pagaefectivo, total, fecha) VALUES (2, 222222222, TRUE, 50000, '8-11-2022');
INSERT INTO compra(idcompra, idcliente, pagaefectivo, total, fecha) VALUES (3, 333333333, TRUE, 55000, '8-11-2022');
INSERT INTO compra(idcompra, idcliente, pagaefectivo, total, fecha) VALUES (4, 333333333, TRUE, 8000, '9-11-2022');
INSERT INTO compra(idcompra, idcliente, numtarjeta, pagaefectivo, total, fecha) VALUES (5, 222222222, '4101010101010105', FALSE, 8000, '9-11-2022');

-- Orden

INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (1, 1, 1, 'Comentario random');
INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (2, 2, 1, 'Comentario random');
INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (3, 3, 1, 'Comentario random');
INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (4, 4, 1, 'Comentario random');
INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (5, 5, 1, 'Comentario random');
INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (6, 1, 3, 'Comentario random');
INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (7, 1, 8, 'Comentario random');
INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (8, 1, 12, 'Comentario random');
INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (9, 1, 20, 'Comentario random');
INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (10, 1, 21, 'Comentario random');

INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (11, 6, 2, 'Comentario random');
INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (12, 7, 2, 'Comentario random');
INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (13, 2, 24, 'Comentario random');
INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (14, 2, 24, 'Comentario random');

INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (15, 8, 3, 'Comentario random');
INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (16, 9, 3, 'Comentario random');
INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (17, 10, 3, 'Comentario random');
INSERT INTO orden(idorden, idmenu_seleccionado, idcompra, observaciones) VALUES (18, 11, 3, 'Comentario random');

INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (19, 4, 18, 'Comentario random');
INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (20, 4, 19, 'Comentario random');
INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (21, 4, 20, 'Comentario random');
INSERT INTO orden(idorden, idcompra, idproducto, observaciones) VALUES (22, 4, 21, 'Comentario random');

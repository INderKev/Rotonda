/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     13/11/2022 10:07:15 p. m.                   */
/*==============================================================*/

/*==============================================================*/
/* Table: ADMINISTRADOR                                         */
/*==============================================================*/
create table ADMINISTRADOR (
   ADMINISTRADORID      INT4                 not null,
   USER_ADMINISTRADOR   VARCHAR(200)         not null,
   PASSWORD_ADMINISTRADOR VARCHAR(100)         not null,
   constraint PK_ADMINISTRADOR primary key (ADMINISTRADORID)
);

/*==============================================================*/
/* Index: ADMINISTRADOR_PK                                      */
/*==============================================================*/
create unique index ADMINISTRADOR_PK on ADMINISTRADOR (
ADMINISTRADORID
);

/*==============================================================*/
/* Table: CLASIFICACION                                         */
/*==============================================================*/
create table CLASIFICACION (
   IDCLASIFICACION      INT4                 not null,
   NOM_CLASIFICACION    VARCHAR(200)         not null,
   constraint PK_CLASIFICACION primary key (IDCLASIFICACION)
);

/*==============================================================*/
/* Index: CLASIFICACION_PK                                      */
/*==============================================================*/
create unique index CLASIFICACION_PK on CLASIFICACION (
IDCLASIFICACION
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   IDCLIENTE            INT4                 not null,
   PRIMERNOMBRE         VARCHAR(100)         not null,
   SEGUNDONOMBRE        VARCHAR(100)         null,
   PRIMERAPELLIDO       VARCHAR(100)         not null,
   SEGUNDOAPELLIDO      VARCHAR(100)         null,
   TELEFONOCLIENTE      VARCHAR(13)          not null,
   CORREO               VARCHAR(200)         not null,
   DIRECCIONCLIENTE     VARCHAR(200)         not null,
   PASSWORDCLIENTE      VARCHAR(50)          not null,
   constraint PK_CLIENTE primary key (IDCLIENTE)
);

/*==============================================================*/
/* Index: CLIENTE_PK                                            */
/*==============================================================*/
create unique index CLIENTE_PK on CLIENTE (
IDCLIENTE
);

/*==============================================================*/
/* Table: TIPO_TARJETA                                          */
/*==============================================================*/
create table TIPO_TARJETA (
   TIPO		 	VARCHAR(25)	     not null,
   IDENTIFICADOR	NUMERIC(1,0)	     not null,
   constraint PK_TIPO_TARJETA primary key (TIPO)
);

/*==============================================================*/
/* Index: TIPO_TARJETA_PK                                       */
/*==============================================================*/
create unique index TIPO_TARJETA_PK on TIPO_TARJETA (
TIPO
);

/*==============================================================*/
/* Table: TARJETA                                               */
/*==============================================================*/
create table TARJETA (
   NUMTARJETA		VARCHAR(16)	     not null,
   PIN			NUMERIC(4,0)	     not null,
   TIPO			VARCHAR(25)	     not null,
   FECHA_CADUCIDAD	DATE		     not null,
   constraint PK_TARJETA primary key (NUMTARJETA)
);

/*==============================================================*/
/* Index: TARJETA_PK                                            */
/*==============================================================*/
create unique index TARJETA_PK on TARJETA (
NUMTARJETA
);

/*==============================================================*/
/* Index: TIPO_TARJETA_FK                                  	*/
/*==============================================================*/
create index TIPO_TARJETA_FK on TARJETA (
TIPO
);

/*==============================================================*/
/* Table: TARJETAS_CLIENTE                                      */
/*==============================================================*/
create table TARJETAS_CLIENTE (
   IDCLIENTE            INT4                 not null,
   NUMTARJETA		VARCHAR(16)	     not null,
   constraint PK_TARJETAS_CLIENTE primary key (IDCLIENTE, NUMTARJETA)
);

/*==============================================================*/
/* Index: CLIENTE_TARJETAS_CLIENTE_FK                           */
/*==============================================================*/
create index CLIENTE_TARJETAS_CLIENTE_FK on TARJETAS_CLIENTE (
IDCLIENTE
);

/*==============================================================*/
/* Index: TARJETA_TARJETAS_CLIENTE_FK                           */
/*==============================================================*/
create index TARJETA_TARJETAS_CLIENTE_FK on TARJETAS_CLIENTE (
NUMTARJETA
);

/*==============================================================*/
/* Index: TARJETAS_CLIENTE_PK                                   */
/*==============================================================*/
create unique index TARJETAS_CLIENTE_PK on TARJETAS_CLIENTE (
IDCLIENTE, NUMTARJETA
);


/*==============================================================*/
/* Table: COMPRA                                                */
/*==============================================================*/
create table COMPRA (
   IDCOMPRA             INT4                 not null,
   IDCLIENTE            INT4                 not null,
   NUMTARJETA           VARCHAR(16)                  ,
   PAGAEFECTIVO         BOOLEAN              not null,  
   TOTAL                NUMERIC(15,2)        not null,
   FECHA                DATE                 not null,
   constraint PK_COMPRA primary key (IDCOMPRA)
);

/*==============================================================*/
/* Index: COMPRA_PK                                             */
/*==============================================================*/
create unique index COMPRA_PK on COMPRA (
IDCOMPRA
);

/*==============================================================*/
/* Index: CLIENTE_COMPRA_FK                                     */
/*==============================================================*/
create index CLIENTE_COMPRA_FK on COMPRA (
IDCLIENTE
);

/*==============================================================*/
/* Index: TARJETA_COMPRA_FK                                     */
/*==============================================================*/
create index TARJETA_COMPRA_FK on COMPRA (
IDCLIENTE, NUMTARJETA
);

/*==============================================================*/
/* Table: ESPECIALIDAD                                          */
/*==============================================================*/
create table ESPECIALIDAD (
   IDESPECIALIDAD       INT4                 not null,
   NOMBRE               VARCHAR(200)         not null,
   constraint PK_ESPECIALIDAD primary key (IDESPECIALIDAD)
);

/*==============================================================*/
/* Index: ESPECIALIDAD_PK                                       */
/*==============================================================*/
create unique index ESPECIALIDAD_PK on ESPECIALIDAD (
IDESPECIALIDAD
);

/*==============================================================*/
/* Table: INGREDIENTE                                           */
/*==============================================================*/
create table INGREDIENTE (
   IDINGREDIENTE        INT4                 not null,
   NOM_INGREDIENTE      VARCHAR(200)         not null,
   TIPO_UNIDAD          VARCHAR(150)         not null,
   DESCRIPCION		VARCHAR(500)		     ,
   constraint PK_INGREDIENTE primary key (IDINGREDIENTE)
);

/*==============================================================*/
/* Index: INGREDIENTE_PK                                        */
/*==============================================================*/
create unique index INGREDIENTE_PK on INGREDIENTE (
IDINGREDIENTE
);

/*==============================================================*/
/* Table: MENU                                                  */
/*==============================================================*/
create table MENU (
   IDMENU               INT4                 not null,
   IDRESTAURANTE        INT4                 not null,
   NOM_MENU             VARCHAR(200)         not null,
   PRECIO               NUMERIC(9,2)         not null,
   IMAGEN_MENU          VARCHAR(400)         not null,
   constraint PK_MENU primary key (IDMENU)
);

/*==============================================================*/
/* Index: MENU_PK                                               */
/*==============================================================*/
create unique index MENU_PK on MENU (
IDMENU
);

/*==============================================================*/
/* Index: RESTAURANTE_MENU_FK                                   */
/*==============================================================*/
create  index RESTAURANTE_MENU_FK on MENU (
IDRESTAURANTE
);

/*==============================================================*/
/* Table: MENU_SELECCIONADO                                     */
/*==============================================================*/
create table MENU_SELECCIONADO (
   IDMENU_SELECCIONADO  INT4                 not null,
   IDMENU               INT4                 not null,
   constraint PK_MENU_SELECCIONADO primary key (IDMENU_SELECCIONADO)
);

/*==============================================================*/
/* Index: MENU_SELECCIONADO_PK                                  */
/*==============================================================*/
create unique index MENU_SELECCIONADO_PK on MENU_SELECCIONADO (
IDMENU_SELECCIONADO
);

/*==============================================================*/
/* Index: MENU_MENUSELECCIONADO_FK                              */
/*==============================================================*/
create  index MENU_MENUSELECCIONADO_FK on MENU_SELECCIONADO (
IDMENU
);

/*==============================================================*/
/* Table: ORDEN                                                 */
/*==============================================================*/
create table ORDEN (
   IDORDEN              INT4                 not null,
   IDMENU_SELECCIONADO  INT4                 null,
   IDCOMPRA             INT4                 not null,
   IDPRODUCTO           INT4                 null,
   OBSERVACIONES        VARCHAR(400)         not null,
   constraint PK_ORDEN primary key (IDORDEN)
);

/*==============================================================*/
/* Index: ORDEN_PK                                              */
/*==============================================================*/
create unique index ORDEN_PK on ORDEN (
IDORDEN
);

/*==============================================================*/
/* Index: ORDEN_MENUSELECCIONADO_FK                             */
/*==============================================================*/
create  index ORDEN_MENUSELECCIONADO_FK on ORDEN (
IDMENU_SELECCIONADO
);

/*==============================================================*/
/* Index: COMPRA_ORDEN_FK                                       */
/*==============================================================*/
create  index COMPRA_ORDEN_FK on ORDEN (
IDCOMPRA
);

/*==============================================================*/
/* Index: ORDEN_PRODUCTO_FK                                     */
/*==============================================================*/
create  index ORDEN_PRODUCTO_FK on ORDEN (
IDPRODUCTO
);

/*==============================================================*/
/* Table: PRODUCTO                                              */
/*==============================================================*/
create table PRODUCTO (
   IDPRODUCTO           INT4                 not null,
   IDRESTAURANTE        INT4                 not null,
   IDCLASIFICACION      INT4                 not null,
   NOM_PRODUCTO         VARCHAR(200)         not null,
   PRECIO_PRODUCTO      NUMERIC(10,2)        not null,
   IMAGEN_PRODUCTO      VARCHAR(400)         not null,
   constraint PK_PRODUCTO primary key (IDPRODUCTO)
);

/*==============================================================*/
/* Index: PRODUCTO_PK                                           */
/*==============================================================*/
create unique index PRODUCTO_PK on PRODUCTO (
IDPRODUCTO
);

/*==============================================================*/
/* Index: RESTAURANTE_PRODUCTO_FK                               */
/*==============================================================*/
create  index RESTAURANTE_PRODUCTO_FK on PRODUCTO (
IDRESTAURANTE
);

/*==============================================================*/
/* Index: CLASIFICACION_PRODUCTO_FK                             */
/*==============================================================*/
create  index CLASIFICACION_PRODUCTO_FK on PRODUCTO (
IDCLASIFICACION
);

/*==============================================================*/
/* Table: PRODUCTO_INGREDIENTE                                  */
/*==============================================================*/
create table PRODUCTO_INGREDIENTE (
   IDPRODUCTOINGREDIENTE INT4                 not null,
   IDINGREDIENTE        INT4                 not null,
   IDPRODUCTO           INT4                 not null,
   CANTIDAD             NUMERIC(10,2)        not null,
   EDITABLE             BOOL                 not null,
   constraint PK_PRODUCTO_INGREDIENTE primary key (IDPRODUCTOINGREDIENTE, IDINGREDIENTE, IDPRODUCTO),
   constraint AK_IDPRODUCTOINGREDIE_PRODUCTO unique (IDPRODUCTOINGREDIENTE)
);

/*==============================================================*/
/* Index: PRODUCTO_INGREDIENTE_PK2                              */
/*==============================================================*/
create unique index PRODUCTO_INGREDIENTE_PK2 on PRODUCTO_INGREDIENTE (
IDPRODUCTOINGREDIENTE,
IDINGREDIENTE,
IDPRODUCTO
);

/*==============================================================*/
/* Index: PRODUCTO_INGREDIENTE2_FK                              */
/*==============================================================*/
create  index PRODUCTO_INGREDIENTE2_FK on PRODUCTO_INGREDIENTE (
IDPRODUCTO
);

/*==============================================================*/
/* Index: PRODUCTO_INGREDIENTE_FK                               */
/*==============================================================*/
create  index PRODUCTO_INGREDIENTE_FK on PRODUCTO_INGREDIENTE (
IDINGREDIENTE
);

/*==============================================================*/
/* Table: RESTAURANTE                                           */
/*==============================================================*/
create table RESTAURANTE (
   IDRESTAURANTE        INT4                 not null,
   IDESPECIALIDAD       INT4                 not null,
   NOM_RESTAURANTE      VARCHAR(250)         not null,
   DIRECCION            VARCHAR(250)         not null,
   TELEFONO             VARCHAR(13)          not null,
   USUARIO_RESTAURANTE  VARCHAR(200)         not null,
   PASSWORD             VARCHAR(70)          not null,
   IMAGEN_RESTAURANTE   VARCHAR(500)         not null,
   constraint PK_RESTAURANTE primary key (IDRESTAURANTE)
);

/*==============================================================*/
/* Index: RESTAURANTE_PK                                        */
/*==============================================================*/
create unique index RESTAURANTE_PK on RESTAURANTE (
IDRESTAURANTE
);

/*==============================================================*/
/* Index: ESPECIALIDAD_RESTAURANTE_FK                           */
/*==============================================================*/
create  index ESPECIALIDAD_RESTAURANTE_FK on RESTAURANTE (
IDESPECIALIDAD
);

/*==============================================================*/
/* Table: SELECCION                                             */
/*==============================================================*/
create table SELECCION (
   IDSELECCION          INT4                 not null,
   IDMENU               INT4                 null,
   IDMENU_SELECCIONADO  INT4                 null,
   IDCLASIFICACION      INT4                 not null,
   IDPRODUCTO           INT4                 null,
   PRECIO_BAJO          NUMERIC(8,2)         null,
   PRECIO_ALTO          NUMERIC(8,2)         null,
   constraint PK_SELECCION primary key (IDSELECCION)
);

/*==============================================================*/
/* Index: SELECCION_PK                                          */
/*==============================================================*/
create unique index SELECCION_PK on SELECCION (
IDSELECCION
);

/*==============================================================*/
/* Index: MENU_SELECCION_FK                                     */
/*==============================================================*/
create  index MENU_SELECCION_FK on SELECCION (
IDMENU
);

/*==============================================================*/
/* Index: MENUSELECCIONADO_SELECCION_FK                         */
/*==============================================================*/
create  index MENUSELECCIONADO_SELECCION_FK on SELECCION (
IDMENU_SELECCIONADO
);

/*==============================================================*/
/* Index: CLASIFICACION_SELECCION_FK                            */
/*==============================================================*/
create  index CLASIFICACION_SELECCION_FK on SELECCION (
IDCLASIFICACION
);

/*==============================================================*/
/* Index: SELECCION_PRODUCTO_FK                                 */
/*==============================================================*/
create  index SELECCION_PRODUCTO_FK on SELECCION (
IDPRODUCTO
);

/*==============================================================*/
/* Table: STOCK                                                 */
/*==============================================================*/
create table STOCK (
   IDSTOCK              INT4                 not null,
   IDRESTAURANTE        INT4                 not null,
   IDINGREDIENTE        INT4                 not null,
   CANTIDAD_STOCK       NUMERIC(10,0)        not null,
   constraint PK_STOCK primary key (IDSTOCK)
);

/*==============================================================*/
/* Index: STOCK_PK                                              */
/*==============================================================*/
create unique index STOCK_PK on STOCK (
IDSTOCK
);

/*==============================================================*/
/* Index: RESTAURANTE_STOCK_FK                                  */
/*==============================================================*/
create  index RESTAURANTE_STOCK_FK on STOCK (
IDRESTAURANTE
);

/*==============================================================*/
/* Index: STOCK_INGREDIENTE_FK                                  */
/*==============================================================*/
create  index STOCK_INGREDIENTE_FK on STOCK (
IDINGREDIENTE
);

alter table TARJETA
   add constraint FK_TARJETA_TIPO_TARJETAS foreign key (TIPO)
      references TIPO_TARJETA (TIPO)
      on delete restrict on update restrict;
      
alter table TARJETAS_CLIENTE
   add constraint FK_CLIENTE_TARJETAS_CLIENTE foreign key (IDCLIENTE)
      references CLIENTE (IDCLIENTE)
      on delete restrict on update restrict;
      
alter table TARJETAS_CLIENTE
   add constraint FK_TARJETA_TARJETAS_CLIENTE foreign key (NUMTARJETA)
      references TARJETA (NUMTARJETA)
      on delete restrict on update restrict;      

alter table COMPRA
   add constraint FK_COMPRA_CLIENTE_C_CLIENTE foreign key (IDCLIENTE)
      references CLIENTE (IDCLIENTE)
      on delete restrict on update restrict;
      
alter table COMPRA
   add constraint FK_COMPRA_TARJETA_CLIENTE foreign key (IDCLIENTE, NUMTARJETA)
      references TARJETAS_CLIENTE (IDCLIENTE, NUMTARJETA)
      on delete restrict on update restrict;

alter table MENU
   add constraint FK_MENU_RESTAURAN_RESTAURA foreign key (IDRESTAURANTE)
      references RESTAURANTE (IDRESTAURANTE)
      on delete restrict on update restrict;

alter table MENU_SELECCIONADO
   add constraint FK_MENU_SEL_MENU_MENU_MENU foreign key (IDMENU)
      references MENU (IDMENU)
      on delete restrict on update restrict;

alter table ORDEN
   add constraint FK_ORDEN_COMPRA_OR_COMPRA foreign key (IDCOMPRA)
      references COMPRA (IDCOMPRA)
      on delete restrict on update restrict;

alter table ORDEN
   add constraint FK_ORDEN_ORDEN_MEN_MENU_SEL foreign key (IDMENU_SELECCIONADO)
      references MENU_SELECCIONADO (IDMENU_SELECCIONADO)
      on delete restrict on update restrict;

alter table ORDEN
   add constraint FK_ORDEN_ORDEN_PRO_PRODUCTO foreign key (IDPRODUCTO)
      references PRODUCTO (IDPRODUCTO)
      on delete restrict on update restrict;

alter table PRODUCTO
   add constraint FK_PRODUCTO_CLASIFICA_CLASIFIC foreign key (IDCLASIFICACION)
      references CLASIFICACION (IDCLASIFICACION)
      on delete restrict on update restrict;

alter table PRODUCTO
   add constraint FK_PRODUCTO_RESTAURAN_RESTAURA foreign key (IDRESTAURANTE)
      references RESTAURANTE (IDRESTAURANTE)
      on delete restrict on update restrict;

alter table PRODUCTO_INGREDIENTE
   add constraint FK_PRODUCTO_PRODUCTO__INGREDIE foreign key (IDINGREDIENTE)
      references INGREDIENTE (IDINGREDIENTE)
      on delete cascade on update cascade;
      
alter table PRODUCTO_INGREDIENTE
   add constraint FK_PRODUCTO_PRODUCTO__PRODUCTO foreign key (IDPRODUCTO)
      references PRODUCTO (IDPRODUCTO)
      on delete restrict on update restrict;

alter table RESTAURANTE
   add constraint FK_RESTAURA_ESPECIALI_ESPECIAL foreign key (IDESPECIALIDAD)
      references ESPECIALIDAD (IDESPECIALIDAD)
      on delete restrict on update restrict;

alter table SELECCION
   add constraint FK_SELECCIO_CLASIFICA_CLASIFIC foreign key (IDCLASIFICACION)
      references CLASIFICACION (IDCLASIFICACION)
      on delete restrict on update restrict;

alter table SELECCION
   add constraint FK_SELECCIO_MENUSELEC_MENU_SEL foreign key (IDMENU_SELECCIONADO)
      references MENU_SELECCIONADO (IDMENU_SELECCIONADO)
      on delete restrict on update restrict;

alter table SELECCION
   add constraint FK_SELECCIO_MENU_SELE_MENU foreign key (IDMENU)
      references MENU (IDMENU)
      on delete restrict on update restrict;

alter table SELECCION
   add constraint FK_SELECCIO_SELECCION_PRODUCTO foreign key (IDPRODUCTO)
      references PRODUCTO (IDPRODUCTO)
      on delete restrict on update restrict;

alter table STOCK
   add constraint FK_STOCK_RESTAURAN_RESTAURA foreign key (IDRESTAURANTE)
      references RESTAURANTE (IDRESTAURANTE)
      on delete cascade on update cascade;

alter table STOCK
   add constraint FK_STOCK_STOCK_ING_INGREDIE foreign key (IDINGREDIENTE)
      references INGREDIENTE (IDINGREDIENTE)
      on delete cascade on update cascade;
   
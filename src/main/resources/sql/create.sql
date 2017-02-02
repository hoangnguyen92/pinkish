CREATE TABLE [pinkish].[dbo].[users](
	[id] [int] IDENTITY(4711,1) NOT FOR REPLICATION NOT NULL,
	[firstname] [nvarchar](50) NULL,
	[lastname] [nvarchar](50) NULL,
	[username] [nvarchar](100) NOT NULL,
	[password] [nvarchar](200) NOT NULL,
	[phone] [nvarchar](15) NULL,
	[email] [nvarchar](100) NULL,
 CONSTRAINT [PK_custlogin] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC,
	[username] ASC,
	[password] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_USERS] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [pinkish].[dbo].[employees](
	[id] [int] IDENTITY(4711,1) NOT FOR REPLICATION NOT NULL,
	[firstname] [nvarchar](50) NULL,
	[lastname] [nvarchar](50) NULL,
	[phone] [nvarchar](15) NULL,
	[email] [nvarchar](100) NULL,
	[weekly_rate] DECIMAL(12,6)
 CONSTRAINT [PK_employees] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [pinkish].[dbo].[employees_payments](
	[id] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[employee_id] [int] NULL,
	[payment_date] datetime,
	[sum] DECIMAL(12,6)
 CONSTRAINT [PK_employees_payments] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [pinkish].[dbo].[vendors](
	[id] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[name] NVARCHAR(100),
	[address] NVARCHAR(100),
	[telephone] NVARCHAR(10),
	[mol] NVARCHAR(50)
 CONSTRAINT [PK_vendors] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


CREATE TABLE [pinkish].[dbo].[customers](
	[id] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[name] NVARCHAR(100),
	[address] NVARCHAR(100),
	[telephone] NVARCHAR(10),
	[mol] NVARCHAR(50)
 CONSTRAINT [PK_customers] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [pinkish].[dbo].[items](
	[id] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[name] NVARCHAR(100),
	[category_id] int,
	[quantity] int,
	[cost] DECIMAL(12,6),
	[price] DECIMAL(12,6),
	[vendor_id] int
 CONSTRAINT [PK_items] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


CREATE TABLE [pinkish].[dbo].[categories](
	[id] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[name] NVARCHAR(100)
 CONSTRAINT [PK_categories] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [pinkish].[dbo].[sale_orders](
	[id] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[quantity] int,
	[vendors_id] int,
	[customer_id] int,
	[type] NVARCHAR(10),
	[sum] DECIMAL(12,6),
	[discount] DECIMAL(12,6)
 CONSTRAINT [PK_sale_orders] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [pinkish].[dbo].[sale_orders_items](
	[id] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[item_id] int,
	[sales_orders_id] int
 CONSTRAINT [PK_sale_orders_items] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

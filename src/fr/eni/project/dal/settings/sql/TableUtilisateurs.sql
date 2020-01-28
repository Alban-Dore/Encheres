USE [DB_PROJECT]
GO

/****** Object:  Table [dbo].[UTILISATEURS]    Script Date: 24/09/2019 11:54:43 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[UTILISATEURS](
	[no_utilisateur] [int] IDENTITY(1,1) NOT NULL,
	[pseudo] [varchar](30) NOT NULL,
	[nom] [varchar](30) NOT NULL,
	[prenom] [varchar](30) NOT NULL,
	[email] [varchar](20) NOT NULL,
	[telephone] [varchar](15) NULL,
	[rue] [varchar](30) NOT NULL,
	[code_postal] [varchar](10) NOT NULL,
	[ville] [varchar](30) NOT NULL,
	[mot_de_passe] [varchar](50) NOT NULL,
	[credit] [int] NOT NULL,
	[administrateur] [bit] NOT NULL
) ON [PRIMARY]
GO


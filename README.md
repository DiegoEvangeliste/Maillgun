# Envio de Email
Se establece el envio de emails mediante los siguientes mecanismos:
- SMTP Client
- Mailgun Client

Se debe configurar las siguientes propiedades:
- **Configuraciones generales**
  - email.sender.option=OPCION_CLIENTE_ENVIO
  - email.from=EMAIL_REMITENTE
- **Configuraciones Mailgun**
  - mailgun.api.key=API_KEY_MAILGUN
  - mailgun.domain=DOMAIN_MAILGUN
- **Configuraciones SMTP** 
  - smtp.host=HOST_SMTP
  - smtp.port=PORT_SMTP
  - smtp.password=CONTRASEÑA_APLICACION_SMTP
# CRUDJAVAEE
CRUD COM JSF PRIMEFACES HIBERNATE E MYSQL


FERRAMENTAS:

IDE: ECLIPSE 2019;
JDK: 1.8
XAMPP: 3.2
WORKBENCH: 8.0

APÓS IMPORTAR O PROJETO PARA DENTRO DO SEU ECLIPSE,
INICIE O XAMPP, DE START NO MYSQL, ABRA O WORKBENCH
CRIE UM BANCO COM O SEGUINTE COMANDO:

CREATE DATABASE cursojavaee;

VÁ ATÉ O ARQUIVO hibernate.cfg E CONFIGURE OS DADOS DO SEU BANCO:

<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/crudjavaee</property>
        <property name="hibernate.connection.username">[COLOQUE O NOME DO USUARIO]</property>
        <property name="hibernate.connection.password">[COLOQUE A SENHA DO BANCO]</property>
        
        MAIS CURSOS E MAIS INFORMAÇÕES:
        
        http://bit.ly/CursoJavaWeb80AulasGratuitas

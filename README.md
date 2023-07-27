# SpringMyBatisExample

- MySQL

```
mysql> CREATE DATABASE `TestDB`;
mysql > use TestB;
mysql> CREATE TABLE `Employee` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(20) DEFAULT NULL,
    `role` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
mysql> insert into `Employee` (
  `name` ,
  `role` 
) values ("アリス", "社長"), ("スーパー", "部長");
```

- pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>SpringMyBatisExample</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	
	<!-- add -->
	<!-- war ファイルを作成 -->
	<packaging>war</packaging>
	<!-- add end -->
	
	<name>SpringMyBatisExample</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<!-- war ファイルを Tomcat にデプロイする場合に必要 -->
		<!-- add -->
		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-tomcat</artifactId>
		    <scope>provided</scope>
		</dependency>
		<!-- add end -->
        
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<!-- add -->
		<dependency>
	        <groupId>mysql</groupId>
	        <artifactId>mysql-connector-java</artifactId>
	        <version>8.0.23</version>
    	</dependency>
		<dependency>
		  <groupId>org.mybatis.spring.boot</groupId>
		  <artifactId>mybatis-spring-boot-starter</artifactId>
		  <version>3.0.1</version>
		</dependency>
		<!-- add end -->

	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>

		<!-- ADD -->
		<pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
	      <plugins>
	        <plugin>
	      	  <groupId>org.mybatis.generator</groupId>
	      	  <artifactId>mybatis-generator-maven-plugin</artifactId>
	          <version>1.3.0</version>
	        </plugin>
	      </plugins>
	   </pluginManagement>
		<!-- ADD END -->

	</build>

</project>
```

- generatorConfig.xml

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN" "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd" >
<generatorConfiguration >
  <!-- mysql connector -->
  <classPathEntry
      location="/Users/cano/.m2/repository/mysql/mysql-connector-java/8.0.23/mysql-connector-java-8.0.23.jar" />

  <context id="context1" >
  
    <!-- JDBC -->
    <jdbcConnection driverClass="com.mysql.jdbc.Driver"
      connectionURL="jdbc:mysql://localhost:3306/TestDB"
      userId="root" password="">

      <!-- Table Configuration matched more than one table 対策 -->
      <!-- http://www.mybatis.org/generator/usage/mysql.html -->
      <property name="nullCatalogMeansCurrent" value="true"/>
      
    </jdbcConnection>
    
      <!-- 自動生成するエンティティ -->

      <javaModelGenerator
          targetPackage="com.example.demo.entity"
          targetProject="src/main/java/"
      />
      <sqlMapGenerator
          targetPackage="com.example.demo.entity"
          targetProject="src/main/java/"
      />
      <javaClientGenerator
          targetPackage="com.example.demo.entity"
          targetProject="src/main/java/"
          type="XMLMAPPER"
      />

    <!-- 自動生成対象のテーブル名 -->
    <table tableName="Employee" domainObjectName="Employee">
      <generatedKey column="id" sqlStatement="JDBC"/> <!-- auto increament 余計なXMLが入ってしまうため不要かも？ -->
    </table>

  </context>
</generatorConfiguration>
```

- application.properties

```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/TestDB
spring.datasource.username=root
spring.datasource.password=
```

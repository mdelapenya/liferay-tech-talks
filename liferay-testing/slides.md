#

---

About me
==================================
- Miguel Pastor
- Core software engineer
- Interested in distributed systems, scalability and PaaS.
- AspectJ and Scala enthusiast. Erlang aficionado.
- Phd student??
- Twitter:@miguelinlas3

---

Agenda
======

- The need of testing
- Unit testing
- Integration testing
- Getting hands dirty
- Q & A

---

The need of testing
========================

- Find bugs as soon as possible
- Make our life happier
- Help to improve our design
- Improve our code quality
---

Unit testing
---------------

- Test our code in an isolated way
-

¿Qué nos llevamos?
------------------

- Fortalecer la plataforma de desarrollo
- Incrementar la adopción de uso del IDE

---

Plataforma desarrollo plugins
=============================

Entorno Desarrollo Java
-----------------------

- JDK
- Liferay Server Tomcat Bundle
- Ant/Maven

Liferay Plugins SDK 
-------------------

- Estructura estándar
- Basado en Ant
- Plantillas para cada uno de los tipos de proyecto
- IDE agnóstico (Idea, Eclipse, STS, ...)
- Disponible un plugin de Maven

---

Liferay IDE 
===========

- Conjunto de plugins para Eclipse (PDE)
- Última versión disponible: 1.4.0
- Soportado en las últimas versiones de Eclipse: Helios, Indigo
- Disponible para desarrolladores Liferay Portal CE
- Utiliza la infraestructura subyacente de Plugins SDK
- Tomcat bundle para la configuración de servidor/runtime
- Necesidad de la configuración de Plugins SDK

---

Liferay Developer Studio
========================

- Personalización Eclipse Indigo + Liferay IDE
- Última versión disponible: 1.3.1 
- Disponible para Liferay Portal EE y cursos de formación 
- Bundles Plugins SDK and Portal EE
- Bundled examples projects
- Soporte servidor WebSphere
- Soporte limitado (hasta el momento Greg por correo)

---

Características Liferay IDE
===========================

- Wizard para la creación de proyectos
- Wizard de importación
- Características del proyecto
- Soporte para servidor Liferay
- Wizards de desarrollo
- Diversos editores Liferay
- Fragmentos (snippets) de código

---

Wizard Nuevo Proyecto
=====================

Soportados 5 tipos de plugins, 3 UI porlet frameworks

![new_project_wizard](img/new_project_wizard.png)

---

Wizard de importación
=====================

Importar un proyecto único,múltiples proyectos del SDK o convertir un proyecto Java existente

![import_project_wizard](img/import_project_wizards.png)

---

Project Features
================

Liferay facets, API classpath contatiner, Liferay 6.x Runtime

![project_features](img/project_features.png)

---

Soporte Servidor Liferay Local 
==============================

Liferay v6.0 (Tomcat 6), Liferay v6.1 (Tomcat 7)

![local_liferay_servers](img/liferay_servers.png)

---

Soporte Servidor Liferay Remoto
===============================

Remote Liferay v6.1 Servers (Tomcat7, Jboss7)

![remote_liferay](img/remote_liferay.png)

---


Wizards de desarrollo
=====================

Portlet (JSF, Vaadin), Hook, Layout Template

![dev_wizards](img/dev_wizards.png)

---

Editores Liferay
================

Portlet, Service Builder, Layout Template

![editors](img/editors.png)

---

Fragmentos de código
====================

Taglibs, Models, Search Container

![snippets](img/snippets.png)

---

Planes de futuro
================

Liferay IDE
-----------

- Soporte maven
- Funcionalidad manejo del portal
- Integración con el Marketplace
- Desarrollo Liferay & Cloud
- Control completo del ciclo de vida del producto (Eclipse)

Liferay Developer Studio
------------------------
- Editor diagramas de workflow
- Soporte para Weblogic

---

Demo
====

Liferay IDE 1.4
---------------
- Desarrollo remoto
- Editor de configuración del portlet
- Editor Service builder

Liferay IDE 1.5 (actualmente en desarrollo)
-------------------------------------------
- Wizard para interactuar con el Marketplace 

---

Contribuye!
===========

Código fuente
-------------

- [GitHub project](http://github.com/liferay/liferay-ide)
- Uso de Maven/Tycho en la construcción del producto
- Uso de Eclipse PDE

OSGi
----
- Plugins Eclipse son bundles OSGI
- Soporte OSGI en Liferay (en proceso)
- La adopción de OSGI supuso un crecimiento notable de la plataforma Eclipse

---

Preguntas (y esperemos respuestas)
==================================


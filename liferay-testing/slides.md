#

---

About me
==================================
- Miguel Pastor
- Core software engineer
- Interested in distributed systems, scalability and PaaS.
- AspectJ and Scala enthusiast. Erlang aficionado.
- Phd student??
- Twitter: @miguelinlas3

---

Agenda
======

- The need of testing
- Unit testing
- Integration testing
- Getting hands dirty
- Jenkins CI Server
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
============

- Test our code in an isolated way
    - No external dependencies
- Independent
- Repeatable
- Easy to execute (by anybody)
- Extremely fast
- Run fast, run often
- __Well written__!!

---

Unit testing in Liferay
=======================

- Application context is not available
- Using mocks/stubs approach
- Tools: __Mockito__ + __PowerMock__ extensions
- Easy to run: __ant test-unit__
- Let´s see some examples

---

Liferay unit test
=================

Using mocks
-----------

- Inyecting mock dependencies
- Mocking method calls
    - Returning values
    - Void methods
- Mocking static methods
- Verify
- Spy

---

Getting hands dirty
====================

- Go next to your buddy
- Choose a class
    - A well known class (if possible)
- Let´s do some unit tests

---

Integration testing
===================

- Test our code with the real dependencies
    - Database, real services, ...
- Components should work altogether
- Independent
- Slower than unit tests
- __Well written__!!

---

Liferay integration test
========================

- Loading the application context
    - Liferay JUnit runner
- Listeners support
- Transactional support
- Test and TestSuites

---

Getting hands dirty
====================

- Go next to your buddy
- Choose a class
    - A well known class (if possible)
- Let´s do some integration tests

---

Improvements
============

- Testing taglibs
- Testing actions
- More??

---

Useful commands
===============

- __ant test__ : run all the tests
- __ant test-unit__ : run the unit tests
- __ant test-integration__ : run all the integration tests
- __ant test-class -Dclass=XXX__: run the class
- __ant sonar__: generates the sonar quality metrics

---

Useful configuration
====================

TODO Complete with an image of the configuration

---

Jenkins CI Server
====================

- Currently monitoring __liferay/liferay-portal/master__
- When a (or multiple) changes are detected run all the tests
- Useful tests results
- Plugins are checked after each succesfull build of the portal
    - At this moment only compiles the plugins
- Quick tour over Jenkins

---

Sonar quality metrics
=====================

- In addition to Jenkins
- Run once a week (currently on Saturday)
- Quality metrics and reports
    - Code coverage
    - Unit tests results
    - Code quality rules
    - Design graphic
    - Code complexity
    - ...

---

Q & A
=====================
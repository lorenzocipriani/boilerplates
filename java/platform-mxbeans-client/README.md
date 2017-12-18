# Platform MxBeans Client

## Introduction

### Background
The JMX technology provides a simple, standard way of managing resources such as 
applications, devices, and services. Because the JMX technology is dynamic, you 
can use it to monitor and manage resources as they are created, installed and 
implemented. You can also use the JMX technology to monitor and manage the Java 
Virtual Machine (Java VM). [1]

Using the JMX technology, a given resource is instrumented by one or more Java 
objects known as Managed Beans, or MBeans. These MBeans are registered in a 
core-managed object server, known as an MBean server. The MBean server acts as a
management agent and can run on most devices that have been enabled for the Java
programming language. [1]

A JMX agent consists of an MBean server, in which MBeans are registered, and a 
set of services for handling the MBeans. In this way, JMX agents directly 
control resources and make them available to remote management applications. [1]

The JMX technology defines standard connectors (known as JMX connectors) that 
enable you to access JMX agents from remote management applications. JMX 
connectors using different protocols provide the same management interface. 
Consequently, a management application can manage resources transparently, 
regardless of the communication protocol used. JMX agents can also be used by 
systems or applications that are not compliant with the JMX specification, as 
long as those systems or applications support JMX agents. [1]

### Aims

-  The JMX technology enables Java applications to be managed without heavy investment.
   A JMX technology-based agent (JMX agent) can run on most Java technology-enabled devices. Consequently, Java applications can become manageable with little impact on their design. A Java application needs only to embed a managed object server and make some of its functionality available as one or several managed beans (MBeans) registered in the object server. That is all it takes to benefit from the management infrastructure.
-  The JMX technology provides a standard way to manage Java applications, systems, and networks.
-  The JMX technology can be used for out-of-the-box management of the Java VM.
   The Java Virtual Machine (Java VM) is highly instrumented using the JMX technology. You can start a JMX agent to access the built-in Java VM instrumentation, and thereby monitor and manage a Java VM remotely.
-  The JMX technology provides a scalable, dynamic management architecture.
   Every JMX agent service is an independent module that can be plugged into the management agent, depending on the requirements. The JMX specification provides a set of core agent services. Additional services can be developed and dynamically loaded, unloaded, or updated in the management infrastructure.
-  The JMX technology leverages existing standard Java technologies.
-  The JMX solutions can use lookup and discovery services and protocols such as Jini network technology and the Service Location Protocol (SLP).
(List taken from [1])

**Monitoring and Management of the Java Virtual Machine**

The JMX technology can also be used to monitor and manage the Java virtual 
machine (Java VM). The Java VM has built-in instrumentation that enables you to 
monitor and manage it by using the JMX technology. These built-in management 
utilities are often referred to as out-of-the-box management tools for the Java 
VM. 

To monitor and manage different aspects of the Java VM, the Java VM includes a 
platform MBean server and special MXBeans for use by management applications 
that conform to the JMX specification.

**Platform MXBeans and the Platform MBean Server**

The platform MXBeans are a set of MXBeans that is provided with the Java SE 
platform for monitoring and managing the Java VM and other components of the 
Java Runtime Environment (JRE). Each platform MXBean encapsulates a part of Java 
VM functionality, such as the class-loading system, just-in-time (JIT) 
compilation system, garbage collector, and so on. These MXBeans can be displayed 
and interacted with by using a monitoring and management tool that complies with 
the JMX specification, to enable you to monitor and manage these different VM 
functionalities.

The Java SE platform provides a standard platform MBean server in which these platform MXBeans are registered. The platform MBean server can also register any other MBeans you wish to create.

### Technologies

MBeans

This lesson introduces the fundamental concept of the JMX API, namely managed beans, or MBeans.

An MBean is a managed Java object, similar to a JavaBeans component, that follows the design patterns set forth in the JMX specification. An MBean can represent a device, an application, or any resource that needs to be managed. MBeans expose a management interface that consists of the following:

    A set of readable or writable attributes, or both.
    A set of invokable operations.
    A self-description.

The management interface does not change throughout the life of an MBean instance. MBeans can also emit notifications when certain predefined events occur.

The JMX specification defines five types of MBean:

    Standard MBeans
    Dynamic MBeans
    Open MBeans
    Model MBeans
    MXBeans

The examples in this trail demonstrate only the simplest types of MBean, namely standard MBeans and MXBeans.



## System

### Requirements

#### Functional Requirements

#### Data Requirements

#### User Requirements

#### Environmental Requirements

#### Usability Requirements

### Design and Architecture

The JMX technology can be divided into three levels, as follows:
-  Instrumentation
-  JMX agent
-  Remote management

**Instrumentation**

You use Java objects known as MBeans to implement the access to the resources' 
instrumentation. MBeans must follow the design patterns and interfaces defined 
in the JMX specification. 
JMX specification also defines a special type of MBean called an MXBean. An 
MXBean is an MBean that references only a pre-defined set of data types.

Once a resource has been instrumented by MBeans, it can be managed through a JMX 
agent. MBeans do not require knowledge of the JMX agent with which they will 
operate. MBeans are designed to be flexible, simple, and easy to implement. 

The instrumentation level of the JMX specification provides a notification 
mechanism. This enables MBeans to generate and propagate notification events to 
components of the other levels.

**JMX Agent**

A JMX technology-based agent (JMX agent) is a standard management agent that 
directly controls resources and makes them available to remote management 
applications. JMX agents are usually located on the same machine as the 
resources they control, but this arrangement is not a requirement.

The core component of a JMX agent is the MBean server, a managed object server 
in which MBeans are registered. A JMX agent also includes a set of services to 
manage MBeans, and at least one communications adaptor or connector to allow 
access by a management application.

**Remote Management**

The MBean server relies on protocol adaptors and connectors to make a JMX agent 
accessible from management applications outside the agent's Java Virtual Machine
(Java VM). Each adaptor provides a view through a specific protocol of all 
MBeans that are registered in the MBean server. For example, an HTML adaptor 
could display an MBean in a browser.

Connectors provide a manager-side interface that handles the communication 
between manager and JMX agent. Each connector provides the same remote 
management interface through a different protocol. When a remote management 
application uses this interface, it can connect to a JMX agent transparently 
through the network, regardless of the protocol. 

The JMX technology provides a standard solution for exporting JMX technology 
instrumentation to remote applications based on Java Remote Method Invocation 
(Java RMI).


### Implementation

### Testing

### Graphical User Interface (GUI)

### Customer Testing

### Evaluation


## Conclusions

## Further Development or Research

## References
[1]. Oracle, "Java Management Extensions (JMX)", [https://docs.oracle.com/javase/tutorial/jmx/index.html](https://docs.oracle.com/javase/tutorial/jmx/index.html)

[2]. Oracle, "Using the Platform MBean Server and Platform MXBeans", [https://docs.oracle.com/javase/7/docs/technotes/guides/management/mxbeans.html](https://docs.oracle.com/javase/7/docs/technotes/guides/management/mxbeans.html)
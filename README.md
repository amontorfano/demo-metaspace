# Metaspace exhaustion on JBoss (Classloader leak)

This project demonstrate the issue of metaspace consumption on JBoss EAP.

## Description of the problem

A webapp is created using Spring-Boot by extending the class `SpringBootServletInitializer`. The DocuSign API Client is autowired into the main class.

The application is compiled as war and deployed onto an instance of JBoss EAP, and eventually undeployed. Analysis of the heap dump shows that a classloader leak exist, involving the object: `com.docusign.esign.client.ApiClient$SecureTrustManager`.

Following several cycles of redeployment, the classloader leak prevents the Metaspace Garbage Collector to free any memory and the deployment fails.

## Steps to reproduce

1. Download the source and compile with `mvn package`.
1. Deploy the WAR on JBoss EAP
1. Undeploy
1. Repeat until metaspace exhaustion





# java-blueberry

# Salón de Belleza Blueberry

### Propuesta TP - Lenguaje de Programación Java

## Integrantes

| Legajo | Apellido y Nombre |
|--------|-------------------|
| 54098 | Rodriguez, Jimena |

## Descripción

El sistema a desarrollar es una aplicación web cliente-servidor que permite la reserva de turnos para distintos tipos de servicios de belleza. Los turnos podrán ser reservados y personalizados por cada cliente, facilitando la organización semanal para los empleados y permitiendo, a su vez, la gestión de diversas promociones y descuentos establecidos por los administradores.

## Modelo de dominio

<img width="752" height="840" alt="tp-java (1)" src="https://github.com/user-attachments/assets/669b9348-1f3b-453f-a74f-8015377ed331" />


## Checklist

### Regularidad

| Requerimiento | Detalle |
| :--- | :--- |
| **ABMC simple** | 1. Servicio |
| **ABMC dependiente** | 1. Promoción {depende de} Servicio|
| **CU NO-ABMC** | 1. CUU Reservar servicio |
| **Listado simple** | 1. Listado de reservas => Detalle muestra tipo de servicio reservado, día, horario, precio y empleado que lo realiza |
| **Listado complejo** | - |

### Aprobación Directa

| Requerimiento | Detalle |
| :--- | :--- |
| **ABMC** | 1. Usuario<br>2. Administrador<br>3. Cliente<br>4. Empleado<br>5. Servicio<br>6. Promoción<br>7. Reserva |
| **CU "Complejo"**(nivel resumen) | 1. CUR Realizar reserva (CUU Cancelar reserva)<br>2. CUR Establecer promoción |
| **Listado complejo** | 1. Listado de horarios posibles para reserva => filtrado por servicio y por horarios disponibles de los empleados |
| **Nivel de acceso** | 1. Usuario<br>2. Empleado<br>3. Administrador |

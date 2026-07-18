# java-blueberry

# Salón de Belleza Blueberry

### Propuesta TP - Lenguaje de Programación Java

## Integrante

| Legajo | Apellido y Nombre |
|--------|-------------------|
| 54098 | Rodriguez, Jimena |

## Descripción

El sistema a desarrollar es una aplicación web cliente-servidor que permite la reserva de turnos para distintos tipos de servicios de belleza. Los turnos podrán ser reservados y personalizados por cada cliente, facilitando la organización semanal para los empleados y permitiendo, a su vez, la gestión de diversas promociones y descuentos establecidos por los administradores.

## Modelo de dominio

<img width="751" height="792" alt="java-fin" src="https://github.com/user-attachments/assets/5c97660c-c7d4-4fb0-a623-147e7cb03069" />

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
| **CU "Complejo"**(nivel resumen) | 1. CUR Establecer promoción <br> 2. CUR Gestión completa del turno (CUU1: Reservar Turno, CUU2: Consultar Turno, CUU3: Cancelar Turno, CUU4: Reprogramar Turno, CUU5: Registrar asistencia)|
| **Listado complejo** | 1. Listado de horarios posibles para reserva => filtrado por servicio y por horarios disponibles de los empleados |
| **Nivel de acceso** | 1. Usuario<br>2. Empleado<br>3. Administrador |

<%-- 
    Document   : index
    Created on : 20/12/2020, 09:17:45 AM
    Author     : USUARIO
--%>

<%@page import="Bean.JavaBeanFactura"%>
<%@page import="Entidades.Factura"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Cliente"%>
<%@page import="Bean.JavaBeanCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tienda</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .tab{
            overflow: hidden;
            border: 1px solid #ccc;
            background-color: #ccffcc;
            }
            
            .tab button {
            background-color: inherit;
            float: left;
            border: none;
            outline: none;
            cursor: pointer;
            padding: 14px 16px;
            transition: 0.3s;
            font-size: 17px;
            }
            
            .tab button:hover {
            background-color: #ccffcc;
            }
            
            .tab button.active {
            background-color: #ccc;
            }
            
            .tabcontent {
            display: none;
            padding: 6px 12px;
            border: 1px solid #ccc;
            border-top: none;
            }
            ul.productos li {
            width: 370px;
            display: inline-block;
            text-align: center;
            background-color:#282828;
            font-family: "Trebuchet MS", Helvetica, sans-serif;
            border-radius: 10px;
            border: 2px solid #585858;
            }
        </style>
    </head>
    <body>
        <h2>Tienda de Celulares</h2>
        <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'Cliente')">Cliente</button>
            <button class="tablinks" onclick="openCity(event, 'Celulares')">Celulares</button>
            <button class="tablinks" onclick="openCity(event, 'Venta')">Venta</button>
        </div>
        
        <form action="ServletAplicacion" method="POST" name="form1">
        <div id="Cliente" class="tabcontent">
            <p>
            Nombre: <input type="text" name="txtNombreC"/>
                
            &emsp; &emsp; &emsp;
            Correo: <input type="text" name="txtCorreoC2"/>
            </p>
            
            <p>
            Apellido: <input type="text" name="txtApellido"/>
                
            &emsp; &emsp; &emsp;
            DNI:<input type="text" name="txtDniC2" id="Dni2"/>
            </p>
            
            <p>
                DNI:<input type="number" name="txtDniC1"/>
            
            &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;

            <input type="submit" value="Ingresar Cliente" name="btnIngresar" onclick="reemp()"/>

            </p>
            
            <p>
            Correo: <input type="text" name="txtCorreoC1"/>
            </p>
                
            &emsp; &emsp; &emsp; &emsp;
            <input type="submit" value="Registrar Cliente" name="btnRegistrarC"/>
            
            <table  class="table table hover" style="width:100%" id="tablaClientes" >
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>DNI</th>
                        <th>Correo</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        JavaBeanCliente jbcliente=new JavaBeanCliente();
                        List<Cliente> lC= jbcliente.ListarTodo();
                        for(Cliente c1:lC ){    
                    %>
                    <tr>
                        <th><%=c1.getNombreCliente()%></th>
                        <th><%=c1.getApellidoCliente()%></th>
                        <th><%=c1.getDniCliente()%></th>
                        <th><%=c1.getEmail()%></th>
                    </tr>
                    <%}%> 
                </tbody>
            </table>
            
            
        </div>
        </form>
        
        <form>
        <div id="Celulares" class="tabcontent">
            
            <ul class="productos" style="color:white;">
            <li><img src="Redmi_Note_9.jpg" />
            <h4>Redmi Note 9</h4>
            <a style="color:white;"> S/.800 </a></li>
            
            <li><img src="Samsung_A10.jpg" />
            <h4>Samsung Galaxy A10</h4>
            <a style="color:white;"> S/.600 </a></li>
            
            <li><img src="Motorola_One.jpg" />
            <h4>Motorola One Fusion</h4>
            <a style="color:white;"> S/.1050 </a></li>
            
            <li><img src="Moto_G9.jpg" />
            <h4>Motorola Moto G9 Play</h4>
            <a style="color:white;"> S/.950 </a></li>
            
            <li><img src="Iphone_11.jpg" />
            <h4>Iphone 11 Pro Max</h4>
            <a style="color:white;"> S/.5400 </a></li>
            
            <li><img src="Huawei_Y7.jpg" />
            <h4>Huawei Y7</h4>
            <a style="color:white;"> S/.1250 </a></li>
            
            <li><img src="Huawei_P40.jpg" />
            <h4>Huawei P40 Lite</h4>
            <a style="color:white;"> S/.650 </a></li>
            
            <li><img src="Samsung_Note_20.jpg" />
            <h4>Samsung Note 20</h4>
            <a style="color:white;"> S/.4100 </a></li>
            
            </ul>
        </div>
        </form>
        
                <form name="form" action="ServletAplicacion" method="GET">
            
        <div id="Venta" class="tabcontent">
            
            <p>Usuario: 
                <input type="number" name="txtUsuario" id="User"/>
            &emsp; &emsp; &emsp; &emsp; &emsp;
            Cantidad
            <select name="cbCantidad">
                <option value="0" selected="selected">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
            &emsp; &emsp;&emsp; &emsp; &emsp; &emsp; &emsp;&emsp; &emsp; &emsp; &ThinSpace;&ThinSpace;&ThinSpace;
            <input type="submit" name="btnActualizar" value="Actualizar" onclick="mult()"/>
            </p>
            <p>Celular: 
                <select name="cbCelular">
                    
                    <option value="800">Redmi Note 9</option>
                    <option value="600">Samsung Galaxy A10</option>
                    <option value="1050">Motorola One Fusion</option>
                    <option value="950">Motorola Moto G9 Play</option>
                    <option value="5400">Iphone 11 Pro Max</option>
                    <option value="1250">Huawei Y7</option>
                    <option value="650">Huawei P40 Lite</option>
                    <option value="4100">Samsung Note 20</option>
                    
                </select>
            &emsp; &emsp; &emsp; &emsp; &emsp;
            Precio Total: 
            <input type="number" name="txtPTotal" id="total"/>
            
            &emsp; &emsp;
            <input type="submit" name="btnVenta" value="Registrar Venta"/>
            </p>
            <p>
                <%java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd");%>
                Fecha Compra
                <input type="text" name="txtFecha" value="<%= df.format(new java.util.Date()) %>"/>
            </p>    
            <table style="width:100%">
                <thead>
                    <tr>
                        <th>Nro Factura</th>
                        <th>Usuario</th>
                        <th>Id Celular</th>
                        <th>Fecha Compra</th>
                        <th>Cantidad</th>
                        <th>Precio Total</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        JavaBeanFactura jbf=new JavaBeanFactura();
                        List<Factura> FC= jbf.ListarTodo();
                        for(Factura fl:FC ){    
                    %>
                    <tr>
                        <th><%=fl.getIdFactura()%></th>
                        <th><%=fl.getDniCliente()%></th>
                        <th><%=fl.getIdcelular()%></th>
                        <th><%=fl.getFechaCompra()%></th>
                        <th><%=fl.getCantidad()%></th>
                        <th><%=fl.getPrecioTotal()%></th>
                    </tr>
                    <%}%> 
                </tbody>
            </table>
        </div>
        </form>
                
                
        <script>
            function openCity(evt, Name) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(Name).style.display = "block";
            evt.currentTarget.className += " active";
            }
        </script>
        <script>
            function mult(){
                var a=parseInt(form.cbCelular.value);
                var b=parseInt(form.cbCantidad.value);
                var c=a*b;
                document.getElementById("total").value=c;
            }
        </script>
        <script>
            function reemp(){
                var a=parseInt(form1.txtDniC2.value);
                document.getElementById("User").value=a;
            }
        </script>
    </body>
</html>

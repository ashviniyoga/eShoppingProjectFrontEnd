 <p class="lead">Shop Name</p>
      <div class="list-group">
      
      <c:forEach items = "${Category}" var = "c">
          <a href="${contextRoot}/show/category/${c.id}/products" class="list-group-item" id="a_${c.name}">${c.name} </a>
         </c:forEach>
      </div>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring Tiles Person Form</title>
</head>
<body>
<h2>Person Manager</h2>
<form action="addPerson.html" method="post">
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">Name</span>
  <input type="text" class="form-control" placeholder="person name" aria-label="person name"
  aria-describedby="basic-addon1" name="PersonName">
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon2">Address</span>
  <input type="text" class="form-control" placeholder="address" aria-label="address"
  aria-describedby="basic-addon2" name="address">
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon2">Age</span>
  <input type="text" class="form-control" placeholder="age" aria-label="age"
  aria-describedby="basic-addon2" name="age">
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon2">Telephone</span>
  <input type="text" class="form-control" placeholder="telephone" aria-label="telephone"
  aria-describedby="basic-addon2" name="telephone">
</div>

<button type="submit" class="btn btn-primary">Submit</button>

</form>
</body>
</html>
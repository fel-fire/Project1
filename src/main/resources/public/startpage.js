      fetch('http://localhost:8080/office/current')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
      document.getElementById('greet').textContent = 'Здравствуйте, ' + data.firstname + ' ' + data.patronimyc + '!';
      document.getElementById('city').textContent = 'Мы здесь: ' + data.town;
      })
      .catch(error => console.error('Fetch error:', error));
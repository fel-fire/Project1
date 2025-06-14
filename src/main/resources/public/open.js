function myFunction() {

      fetch('http://localhost:8080/accounts/open')
        .then(response => {
          if (!response.ok) {
            throw new Error('Ошибка HTTP: ' + response.status);
          }
          return response.json();
        })
        .then(result => {
          console.log('Ответ сервера:', result);
          window.location.href = 'startpage.html';
        })
        .catch(error => {
          console.error('Произошла ошибка:', error);
        });
        window.location.href = 'startpage.html';
        location.reload();
        window.location.href = 'startpage.html';
        location.reload();
    }
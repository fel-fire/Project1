const data = { name: "example"};

fetch('http://localhost:8080/employees', {
  method: 'POST', // Метод запроса
  headers: {
    'Content-Type': 'application/json' // Тип содержимого
  },
  body: JSON.stringify(data) // Преобразуем объект в JSON-строку
})
  .then(response => {
    if (!response.ok) {
      throw new Error('Ошибка HTTP: ' + response.status);
    }
    return response.json(); // Получаем тело ответа как JSON
  })
  .then(result => {
    console.log('Ответ сервера:', result);
  })
  .catch(error => {
    console.error('Произошла ошибка:', error);
  });
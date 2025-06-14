fetch('http://localhost:8080/transfer/history')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {

            const table = document.createElement('table');
            table.border = '1'; // Добавим рамку для наглядности

            // Создаём заголовок таблицы на основе ключей первого объекта
            const thead = table.createTHead();
            const headerRow = thead.insertRow();
            Object.keys(data[0]).forEach(key => {
              const th = document.createElement('th');
              th.textContent = key;
              headerRow.appendChild(th);
            });

            // Заполняем таблицу данными
            const tbody = table.createTBody();
            data.forEach(item => {
              const row = tbody.insertRow();
              Object.values(item).forEach(text => {
                const cell = row.insertCell();
                cell.textContent = text;
              });
            });

            // Добавляем таблицу в тело документа (например, в div с id="table-container")
            document.getElementById('table-container').appendChild(table);
      })
      .catch(error => console.error('Fetch error:', error));
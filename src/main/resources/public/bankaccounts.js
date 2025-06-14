fetch('http://localhost:8080/accounts')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
            document.getElementById('amount').textContent = 'Всего бабла: ' + data.amount;

            const table = document.createElement('table');
            table.border = '1';


            const thead = table.createTHead();
            const headerRow = thead.insertRow();
            Object.keys(data.accounts[0]).forEach(key => {
              const th = document.createElement('th');
              th.textContent = key;
              headerRow.appendChild(th);
            });


            const tbody = table.createTBody();
            data.accounts.forEach(item => {
              const row = tbody.insertRow();
              Object.values(item).forEach(text => {
                const cell = row.insertCell();
                cell.textContent = text;
              });
            });

            document.getElementById('table-container').appendChild(table);
      })
      .catch(error => console.error('Fetch error:', error));
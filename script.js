document.addEventListener('DOMContentLoaded', function () {
  // Function to generate random machine quantities
  function generateRandomQuantities() {
    return Math.floor(Math.random() * 20) + 1; // Generates a random number between 1 and 20
  }

  // Function to fetch machine details
  function fetchMachineDetails() {
    // Replace this with your logic to fetch machine details
    // For demonstration purposes, we'll use a dummy array of machines
    const machines = [
      { name: 'Aspirin ', quantity: generateRandomQuantities() },
      { name: 'Machine ', quantity: generateRandomQuantities() },
      { name: 'Machine ', quantity: generateRandomQuantities() },
       
    ];

    // Update the HTML with machine details
    const machineDetailsElement = document.getElementById('machineDetails');
    machineDetailsElement.innerHTML = `
      <h2>Machine List</h2>
      <ul>
        ${machines.map(machine => `<li><strong>${machine.name}:</strong> ${machine.quantity} units</li>`).join('')}
      </ul>
      <p><strong>Last Updated:</strong> ${new Date().toLocaleTimeString()}</p>




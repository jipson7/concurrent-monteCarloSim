data = importdata('partb-data.txt');

time = data(:,1);

error = data(:,2);

plot(time, error, 'ko');

fitCurve = fit(time, error, 'poly5');

hold on; plot(fitCurve, 'r-');

xlabel('Execution Time (Milliseconds)');

ylabel('Magnitude of Error');

title('Part b - No Threading');
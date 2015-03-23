data2 = importdata('partd-data-2.txt');
data4 = importdata('partd-data-4.txt');
data8 = importdata('partd-data-8.txt');
data16 = importdata('partd-data-16.txt');
data32 = importdata('partd-data-32.txt');



fitData2 = fit(data2(:,1), data2(:,2), 'poly5');
fitData4 = fit(data4(:,1), data4(:,2), 'poly5');
fitData8 = fit(data8(:,1), data8(:,2), 'poly5');
fitData16 = fit(data16(:,1), data16(:,2), 'poly5');
fitData32 = fit(data32(:,1), data32(:,2), 'poly5');

hold on;

plot(fitData2, 'm-');
axis([0 4000 (0) (3*10^(-3))]);
plot(fitData4, 'c-');
axis([0 4000 (0) (3*10^(-3))]);
plot(fitData8, 'r-');
axis([0 4000 (0) (3*10^(-3))]);
plot(fitData16, 'g-');
axis([0 4000 (0) (3*10^(-3))]);
plot(fitData32, 'b-');
axis([0 4000 (0) (3*10^(-3))]);

legend('2 Threads', '4 Threads', '8 Threads', '16 Threads', '32 Threads');

xlabel('Execution Time (Milliseconds)');

ylabel('Magnitude of Error');

title('Part d - Threading');
FROM node:latest as builder

RUN mkdir -p /app

WORKDIR /app

COPY . .

RUN npm install
RUN npm run build --prod

CMD ["npm", "start"]

# Stage 2: Serve app with nginx server

# Use official nginx image as the base image
FROM nginx:latest

# Stage 2: Serve app with nginx server

# Use official nginx image as the base image
FROM nginx:latest

# Copy the build output to replace the default nginx contents.
COPY --from=build /usr/local/app/dist/FoodboxFrontend /usr/share/nginx/html

# Expose port 80
EXPOSE 4200


